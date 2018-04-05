package net.practice.stock.news.screener.batch;

import net.practice.stock.news.screener.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {

  private static final int DELAY = 30 * 60 * 1000;

  @Value("${news.rss.feed.urls}")
  private String[] urls;

  @Autowired
  private NewsService newsService;

  @Scheduled(fixedDelay = DELAY)
  public void loadNews() {
    newsService.loadNews(urls);
  }
}
