package net.practice.stock.news.screener.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sameer
 */
@Entity
@Table(name = "stock")
public class Stock {

  @Id
  private String symbol;
  private String name;

  public Stock() {
  }

  public Stock(String symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Stock stock = (Stock) o;
    return symbol.equals(stock.symbol);
  }

  @Override
  public int hashCode() {
    return symbol.hashCode();
  }

  @Override
  public String toString() {
    return "Stock{" +
      "symbol='" + symbol + '\'' +
      ", name='" + name + '\'' +
      '}';
  }

}

