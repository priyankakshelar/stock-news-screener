package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.News;
import net.practice.stock.news.screener.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sameer
 */
@Component
public class NewsServiceImpl implements NewsService {
  @Autowired
  NewsRepository newsRepository;

  @Override
  public List<News> getAllNews() {
    Iterator <News> newsIterator = newsRepository.findAll().iterator();
    List<News> news = new ArrayList<>();
    while ( newsIterator.hasNext()){
     News n= newsIterator.next();
     news.add(n);
      System.out.println("News...  "+n);
    }

    return news;
  }
}
