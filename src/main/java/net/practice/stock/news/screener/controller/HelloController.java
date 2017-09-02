package net.practice.stock.news.screener.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

  @Value("${welcome.message:test}")
  private String message = "Hello World";

  @RequestMapping( "/" )
  public String index(Model model) {
    System.out.println("foooooooooosadfoosdfas");
    Map< String, String > stocks = new HashMap<String, String>();
    stocks.put("infy", "Infosys");
    stocks.put("tcs", "TCS");
    model.addAttribute("stockMap", stocks);
    model.addAttribute("stock", new StockSearch());
    return "search";
  }
  @RequestMapping(value="/search-news",method= RequestMethod.POST)
  public String showResult(@ModelAttribute("Sprin")StockSearch stock, ModelMap model){

    model.addAttribute("stockMap", stock);
    System.out.println("STOCK SELECTED:::"+stock.getSelectedStock());
    return "result";
  }


}
