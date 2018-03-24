package net.practice.stock.news.screener.controller;

import net.practise.stock.news.screener.validator.ValidDate;

public class NewsSearch {

  private String selectedStock;
  @ValidDate(format = "yyyy-MM-dd")
  private String startDate;
  @ValidDate(format = "yyyy-MM-dd")
  private String endDate;

  public String getSelectedStock() {
    return selectedStock;
  }

  public void setSelectedStock(String selectedStock) {
    this.selectedStock = selectedStock;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }



  @Override
  public String toString() {
    return "NewsSearch{" +
      "selectedStock='" + selectedStock + '\'' +
      ", startDate='" + startDate + '\'' +
      ", endDate='" + endDate + '\'' +
      '}';
  }

}
