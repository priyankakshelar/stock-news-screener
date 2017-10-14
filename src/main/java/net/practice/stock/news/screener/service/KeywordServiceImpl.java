package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class KeywordServiceImpl implements KeywordService {
  @Autowired
  private KeywordRepository keywordRepository;

  @Override
  public List<Keyword> getAllKeyword() {
    Iterator<Keyword> keywordIterable = keywordRepository.findAll().iterator();
    List<Keyword> keywords = new ArrayList<>();
    while (keywordIterable.hasNext()) {
      Keyword keyword = keywordIterable.next();
      keywords.add(keyword);
    }
    return keywords;
  }
}
