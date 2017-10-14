package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.News;

import java.util.List;

/**
 * @author sameer
 */
public interface NewsService {
  List<News> getAllNews();
  List<News> findNews(String symbol);
  void loadNews();

}
