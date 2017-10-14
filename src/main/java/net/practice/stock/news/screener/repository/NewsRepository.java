package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sameer
 */
public interface NewsRepository extends JpaRepository<News, Integer> {

  List<News> findBySymbol(String symbol);

}
