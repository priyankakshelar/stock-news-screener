package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {

}
