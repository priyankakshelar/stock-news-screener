package net.practice.stock.news.screener.controller;

import net.practice.stock.news.screener.entity.News;
import net.practice.stock.news.screener.entity.Stock;
import net.practice.stock.news.screener.service.KeywordService;
import net.practice.stock.news.screener.service.NewsService;
import net.practice.stock.news.screener.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    model.addAttribute("newsSearch", new NewsSearch());
    return "search";
  }

  @RequestMapping(value = "/search-news", method = RequestMethod.POST)
  public String getResult(@Valid NewsSearch newsSearch, BindingResult theBindingResult, Model model) throws ParseException {
    if (theBindingResult.hasErrors()) {
      return "search";
    } else {
      List<News> news = newsService.findNews(newsSearch.getSelectedStock(), toDate(newsSearch.getStartDate()), toDate(newsSearch.getEndDate()));
      model.addAttribute("newsSearch", newsSearch);
      model.addAttribute("newsList", news);
      return "result";
    }
  }

  @ModelAttribute("stockOptions")
  public Map<String, String> initStockOptions() {
    List<Stock> stocks = stockService.findAllStocks();
    return getStockSymbolToNameMap(stocks);
  }

  private Map<String, String> getStockSymbolToNameMap(List<Stock> stocks) {
    Map<String, String> stockSymbolToNameMap = new TreeMap<>();
    for (Stock stock : stocks) {
      stockSymbolToNameMap.put(stock.getSymbol(), stock.getName());/////////////
    }
    return stockSymbolToNameMap;
  }

  private Date toDate(String input) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return simpleDateFormat.parse(input);
  }
}

