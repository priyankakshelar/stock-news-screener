package net.practice.stock.news.screener.controller;

public class NewsSearch {

  private String selectedStock;

  public String getSelectedStock() {
    return selectedStock;
  }

  public void setSelectedStock(String selectedStock) {
    this.selectedStock = selectedStock;
  }

  @Override
  public String toString() {
    return "NewsSearch{" +
      "selectedStock='" + selectedStock + '\'' +
      '}';
  }
}
