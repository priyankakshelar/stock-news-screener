package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.entity.Stock;
import net.practice.stock.news.screener.repository.KeywordRepository;
import net.practice.stock.news.screener.repository.StockRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sameer
 */
@Component
public class StartupService {

  @Autowired
  private KeywordRepository keywordRepository;

  @Autowired
  private StockRepository stockRepository;

  @PostConstruct
  public void init() throws IOException {
    Long count = stockRepository.count();
    if (count == 0) {
      loadStock("stocks.csv");
    }
  }

  private void loadStock(String fileName) throws IOException {
    Set<Stock> stocks = new HashSet<>();
    Set<Keyword> stockKeywords = new HashSet<>();
    String filePath = getClass().getClassLoader().getResource(fileName).getFile();
    File file = new File(filePath);
    List<String> lines = FileUtils.readLines(file, "UTF-8");
    lines.remove(0);
    for (String line : lines) {
      String[] attributes = line.split(",");
      Stock stock = createStock(attributes);
      stocks.add(stock);
      Keyword keyword = createKeyword(stock);
      stockKeywords.add(keyword);
    }
    stockRepository.save(stocks);
    keywordRepository.save(stockKeywords);
  }

  private Stock createStock(String[] attributes) {
    String symbol = attributes[0];
    String name = attributes[1];
    return new Stock(symbol, name);
  }

  private Keyword createKeyword(Stock stock) {
    String name = stock.getName();
    String keyword = name.replaceAll(" Limited", "");
    return new Keyword(keyword, stock.getSymbol());
  }
}
