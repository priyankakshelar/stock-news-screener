package net.practice.stock.news.screener.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.entity.News;
import net.practice.stock.news.screener.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class NewsServiceImpl implements NewsService {

  @Autowired
  private NewsRepository newsRepository;

  @Autowired
  private KeywordService keywordService;

  @Value("${news.rss.feed.urls}")
  private String[] urls;

  @Override
  public void loadNews() {
    for (String url : urls) {
      loadNews(url);
    }
  }

  @Override
  public List<News> findNews(String symbol) {
    List<News> newsList = newsRepository.findBySymbol(symbol);
    return newsList;
  }

  private void loadNews(String url) {
    try {
      URL feedUrl = new URL(url);
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedUrl));
      List<SyndEntry> entries = feed.getEntries();
      List<News> newsList = toNewsList(entries);
      newsRepository.save(newsList);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private List<News> toNewsList(List<SyndEntry> entries) {
    List<News> newsList = new ArrayList<>();
    for (SyndEntry entry : entries) {
      String symbol = getSymbol(entry.getTitle());
      if (symbol != null) {
        News news = new News();
        news.setTitle(entry.getTitle());
        news.setDescription(entry.getDescription().getValue());
        news.setPublishDate(entry.getPublishedDate());
        news.setLink(entry.getLink());
        news.setSymbol(symbol);

        newsList.add(news);
      }
    }
    return newsList;
  }

  private String getSymbol(String title) {
    List<Keyword> keywordList = keywordService.getAllKeyword();
    for (Keyword keyword : keywordList) {
      boolean contains = title.contains(keyword.getKeyword());
      if (contains) {
        return keyword.getStockSymbol();
      }
    }
    return null;
  }
}
