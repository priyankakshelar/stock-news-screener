package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sameer
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}
