package net.practice.stock.news.screener.controller;

import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.entity.Stock;
import net.practice.stock.news.screener.service.KeywordService;
import net.practice.stock.news.screener.service.NewsService;
import net.practice.stock.news.screener.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    model.addAttribute("stock", new StockSearch());
    newsService.getAllNews();
    newsService.loadNews();
    return "search";
  }

// method to convert list to map
  private Map<String, String> getStockSymbolToNameMap(List<Stock> stocks) {
    Map<String, String> stockSymbolToNameMap = new HashMap<String, String>();
    for (Stock stock: stocks) {
      stockSymbolToNameMap.put(stock.getSymbol(), stock.getName());
    }
    return stockSymbolToNameMap;
  }

  @RequestMapping(value = "/search-news", method = RequestMethod.POST)
  public String getResult(StockSearch stock, Model model) {
    //System.out.println("stock " + stock);
    model.addAttribute("stock", stock);
    List<Keyword> keywords = keywordService.getAllKeyword();
    Map<String, String> keywordSymbolToNameMap = new HashMap();
    for (Keyword keyword : keywords) {
      keywordSymbolToNameMap.put(keyword.getKeyword(), keyword.getStockSymbol());
     // System.out.println("\nKEYWORDS..." + keywordSymbolToNameMap);
    }

    return "result";
  }
}

 /* @RequestMapping(value="/serch-keyword",method = RequestMethod.POST)
  public String findKeyword(Model model) {
    List<Keyword> keywords = keywordService.getAllKeyword();
    Map<String,String> keywordSymbolToNameMap=new HashMap();
    for(Keyword keyword:keywords){
      keywordSymbolToNameMap.put(keyword.getKeyword(),keyword.getStockSymbol());
      System.out.println("KEYWORDS..."+keyword);
    }
    return "search";

  }
  }
*/
