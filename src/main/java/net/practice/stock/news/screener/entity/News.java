package net.practice.stock.news.screener.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {

  @Id
  private String link;
  private String title;
  private String description;
  private String symbol;
  @Column(name = "publish_date")
  private Date publishDate;


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


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "News{" +
      "link='" + link + '\'' +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", symbol='" + symbol + '\'' +
      ", publishDate=" + publishDate +
      '}';
  }
}
