package net.practice.stock.news.screener.controller;

import net.practice.stock.news.screener.entity.News;
import net.practice.stock.news.screener.entity.Stock;
import net.practice.stock.news.screener.service.KeywordService;
import net.practice.stock.news.screener.service.NewsService;
import net.practice.stock.news.screener.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class StockNewsController {

  @Autowired
  private StockService stockService;

  @Autowired
  private KeywordService keywordService;

  @Autowired
  private NewsService newsService;

  @RequestMapping("/")
  public String index(Model model) {
    List<Stock> stocks = stockService.findAllStocks();
    Map<String, String> stockSymbolToNameMap = getStockSymbolToNameMap(stocks);
    model.addAttribute("stockOptions", stockSymbolToNameMap);
    model.addAttribute("newsSearch", new NewsSearch());
    return "search";
  }

  @RequestMapping(value = "/search-news", method = RequestMethod.POST)
  public String getResult(NewsSearch newsSearch, Model model) {
    List<News> news = newsService.findNews(newsSearch.getSelectedStock());
    model.addAttribute("newsSearch", newsSearch);
    model.addAttribute("newsList", news);
    return "result";
  }

  private Map<String, String> getStockSymbolToNameMap(List<Stock> stocks) {
    Map<String, String> stockSymbolToNameMap = new TreeMap<>();
    for (Stock stock : stocks) {
      stockSymbolToNameMap.put(stock.getSymbol(), stock.getName());
    }
    return stockSymbolToNameMap;
  }
}

