package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Stock;

import java.util.List;

/**
 * @author sameer
 */
public interface StockService {

  List<Stock> findAllStocks();// method to return stocks


}