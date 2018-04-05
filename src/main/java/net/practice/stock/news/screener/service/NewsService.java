package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.News;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface NewsService {

  List<News> findNews(String symbol, Date startDate, Date endDate) throws ParseException;

  void loadNews(String[] urls);
}
