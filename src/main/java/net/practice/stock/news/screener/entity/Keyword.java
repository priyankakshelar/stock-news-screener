package net.practice.stock.news.screener.entity;

import javax.persistence.*;

@Entity
@Table(name = "stock_keyword")
public class Keyword {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String keyword;

  @Column(name = "stock_symbol")
  private String stockSymbol;

  public Keyword() {
  }

  public Keyword(String keyword, String stockSymbol) {
    this.keyword = keyword;
    this.stockSymbol = stockSymbol;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getStockSymbol() {
    return stockSymbol;
  }

  public void setStockSymbol(String stockSymbol) {
    this.stockSymbol = stockSymbol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Keyword)) return false;
    Keyword keyword = (Keyword) o;
    return stockSymbol.equals(keyword.stockSymbol);
  }

  @Override
  public int hashCode() {
    return stockSymbol.hashCode();
  }

  @Override
  public String toString() {
    return "Keyword{" +
      "keyword='" + keyword + '\'' +
      ", stockSymbol='" + stockSymbol + '\'' +
      '}';
  }
}
