package net.practice.stock.news.screener.repository;

import net.practice.stock.news.screener.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

}

