package net.practice.stock.news.screener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StockNewsController {

  @RequestMapping("/")
  public String index(Model model) {
    Map<String, String> stocks = new HashMap<String, String>();
    stocks.put("infy", "Infosys");
    stocks.put("tcs", "TCS");
    model.addAttribute("stockOptions", stocks);
    model.addAttribute("stock", new StockSearch());
    return "search";
  }

  @RequestMapping(value = "/search-news", method = RequestMethod.POST)
  public String getResult(StockSearch stock, Model model) {
    System.out.println("stock " + stock);
    model.addAttribute("stock",stock);
    return "result";
  }

}
