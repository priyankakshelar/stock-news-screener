package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sameer
 */
public interface StockRepository extends JpaRepository<Stock, String> {// <entity,data type of primary key>

}
