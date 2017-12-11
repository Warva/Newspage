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
import wad.domain.Category;
import wad.domain.NewsItem;
import wad.domain.Writer;

/**
 *
 * @author Warva
 */
public class DomainTest {
    
    public DomainTest() {
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

    // Testataan olion Category luonti
    @Test
    public void categoryCreateTest() {
        Category category = new Category();
        category.setName("nimi");
        
        assertEquals("nimi", category.getName());
    }
    
    // Testataan olion Writer luonti
    @Test
    public void writerCreateTest() {
        Writer writer = new Writer();
        writer.setName("nimi");
        
        assertEquals("nimi", writer.getName());
    }
    
    // Testataan olion NewsItem luonti
    @Test
    public void newsItemCreateTest() {
        NewsItem newsItem = new NewsItem();
        newsItem.setTitle("Otsikko");
        
        assertEquals("Otsikko", newsItem.getTitle());
    }
    
}
