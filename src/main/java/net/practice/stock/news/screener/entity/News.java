package net.practice.stock.news.screener.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author sameer
 */
@Entity
@Table(name = "news")
public class News {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  private String description;
  private String symbol;
  @Column(name = "publish_date")
  private Date publishDate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  @Override
  public String toString() {
    return "News{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", symbol='" + symbol + '\'' +
      ", publishDate=" + publishDate +
      '}';
  }
}
