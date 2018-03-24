package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {

  List<News> findBySymbol(String symbol);

  @Query(value = "SELECT n FROM News n WHERE n.publishDate BETWEEN ?1 AND ?2")
  List<News> findByDate(Date startDate, Date endDate);

  @Query(value = "SELECT * FROM news WHERE symbol = ?1 and publish_date BETWEEN  ?2 and ?3", nativeQuery = true)
  List<News> findBySymbolAndDate(String symbol, Date startDate, Date endDate);
}
