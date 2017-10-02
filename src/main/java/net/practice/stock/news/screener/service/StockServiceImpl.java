package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Stock;
import net.practice.stock.news.screener.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sameer
 */
@Component
public class StockServiceImpl implements StockService {

  @Autowired
  private StockRepository stockRepository;

  @Override
  public List<Stock> findAllStocks() {
    Iterator<Stock> stockIterable = stockRepository.findAll().iterator();
    List<Stock> stocks = new ArrayList<Stock>();
    while (stockIterable.hasNext()) {
      Stock stock = stockIterable.next();
      stocks.add(stock);
    }
    return stocks;
  }

}
