package net.practice.stock.news.screener.service;

import net.practice.stock.news.screener.entity.Keyword;
import net.practice.stock.news.screener.entity.News;
import net.practice.stock.news.screener.repository.NewsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author sameer
 */
public class NewsServiceImplTest {

  @Mock
  private NewsRepository newsRepository;

  @Mock
  private KeywordService keywordService;

  @InjectMocks
  private NewsService newsService = new NewsServiceImpl();

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFindNewsBySymbolAndDate() throws Exception {
    // given
    String symbol = "INFY";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = sdf.parse("2017-01-01");
    Date endDate = sdf.parse("2017-12-31");
    Mockito.when(newsRepository.findBySymbolAndDate(symbol, startDate, endDate)).thenReturn(getNewsList());

    // when
    List<News> newsList = newsService.findNews(symbol, startDate, endDate);

    // then
    // assert
    assertEquals(2, newsList.size());
    News news1 = newsList.get(0);
    assertEquals("http://inf1", news1.getLink());
  }

  @Test
  public void testFindNewsByDate() throws Exception {
    //given
    String symbol = "-";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = sdf.parse("2017-01-01");
    Date endDate = sdf.parse("2017-12-31");
    Mockito.when(newsRepository.findByDate(startDate, endDate)).thenReturn(getNewsList());
    //when
    List<News> newsList = newsService.findNews(symbol, startDate, endDate);

    // then
    assertEquals(2, newsList.size());
    News news1 = newsList.get(0);
    assertEquals("http://inf1", news1.getLink());
  }

  @Test
  public void testFindNewsBySymbol() throws Exception {
    // given
    String symbol = "INFY";
    Date startDate = null;
    Date endDate = null;
    Mockito.when(newsRepository.findBySymbol(symbol)).thenReturn(getNewsList());

    //when
    List<News> newsList = newsService.findNews(symbol, startDate, endDate);

    //then
    assertEquals(2, newsList.size());
    News news1 = newsList.get(0);
    assertEquals("http://inf1", news1.getLink());
  }

  @Test
  public void testLoadNews() throws ParseException {
    // given
    String rssFeedUrl = getClass().getClassLoader().getResource("rssfeed.xml").toString();
    String[] urls = {rssFeedUrl};
    Mockito.when(keywordService.getAllKeyword()).thenReturn(getKeywords());
    // when
    newsService.loadNews(urls);

    // then
    ArgumentCaptor<List<News>> listCaptor = ArgumentCaptor.forClass((Class) List.class);
    Mockito.verify(newsRepository, Mockito.times(1)).save(listCaptor.capture());
    List<News> actualList = listCaptor.getValue();
    assertEquals(1, actualList.size());
    News news = actualList.get(0);

    assertEquals("Ashok Leyland to increase vehicle prices by at least 2% from April", news.getTitle());
    assertEquals("https://www.moneycontrol.com/news/business/ashok-leyland-to-increase-vehicle-prices-by-at-least-2april_10711701.html", news.getLink());
    assertEquals("<img src=\"https://www.moneycontrol.com/news_image_files/2018/200x200/A/Ashok-Leyland-Circuit-1_200.jpg\" alt=\"Ashok Leyland to increase vehicle prices by at least 2% from April\" title=\"Ashok Leyland to increase vehicle prices by at least 2% from April\" border=\"0\" width=\"75\" height=\"75\" align=\" left\" hspace=\"5\" />The company would be increasing prices of its entire range of vehicles by a minimum of 2 percent, the Hinduja group flagship firm said in a statement.", news.getDescription());
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z");
    Date expectedDate = formatter.parse("27 Mar 2018 17:52:12 +0530");
    assertTrue(Math.abs(expectedDate.getTime() - news.getPublishDate().getTime()) < 10e-10);
  }

  private List<News> getNewsList() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date publishDate = sdf.parse("2017-01-01");
    List<News> newsList = new ArrayList<News>();
    News infyNews1 = new News("http://inf1", "Infy news title 1", "description", "INFY", publishDate);
    newsList.add(infyNews1);
    News infyNews2 = new News("http://inf2", "Infy news title 2", "description 2", "INFY", publishDate);
    newsList.add(infyNews2);
    return newsList;
  }

  private List<Keyword> getKeywords() {
    List<Keyword> keywordList = new ArrayList<>();
    Keyword bajajAuto = new Keyword("Bajaj Auto", "BJ");
    keywordList.add(bajajAuto);
    Keyword icici = new Keyword("ICICI", "ICICI");
    keywordList.add(icici);
    Keyword ashokLeyland = new Keyword("Ashok Leyland", "ASHL");
    keywordList.add(ashokLeyland);
    return keywordList;

  }
}
