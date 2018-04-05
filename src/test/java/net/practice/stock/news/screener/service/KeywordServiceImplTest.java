package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.repository.KeywordRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sameer
 */
public class KeywordServiceImplTest {

  @Mock
  private KeywordRepository keywordRepository;
  @InjectMocks
  private KeywordService keywordService = new KeywordServiceImpl();

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllKeyword() throws Exception {
    // given
    Mockito.when(keywordRepository.findAll()).thenReturn(getKeywordList());

    // when
    List<Keyword> keywords = keywordService.getAllKeyword();

    // then
    //assert
    Assert.assertEquals(2, keywords.size());
    Keyword keyword = keywords.get(0);
    Assert.assertEquals(new Integer(1), keyword.getId());
  }

  public List<Keyword> getKeywordList() {
    List<Keyword> keywords = new ArrayList<>();
    Keyword infyKeyword = new Keyword(1, "infosys", "INFY");
    keywords.add(infyKeyword);
    Keyword tcsKeyword = new Keyword(1, "tcs", "TCS");
    keywords.add(tcsKeyword);

    return keywords;
  }
}
