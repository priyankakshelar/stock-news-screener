package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.News;

import java.util.List;

public interface NewsService {
  List<News> findNews(String symbol);

  void loadNews();

}
