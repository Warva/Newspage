/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.domain.NewsItem;
import wad.service.NewsService;

/**
 *
 * @author Warva
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceTest {
    
    @Autowired
    private NewsService newsService;
    
    public NewsServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void latestNewsTest() {
        NewsItem newsItem = new NewsItem();
        newsItem.setTitle("Otsikko"); 
        
        assertNotNull(newsService.latestNews()); 
    }
    
    @Test
    public void loadedNewsTest() {
        NewsItem newsItem = new NewsItem();
        newsItem.setTitle("Otsikko");
        newsItem.setLoaded(newsItem.getLoaded()+1);
        
        assertNotNull(newsService.loadedNews());
    }
}
