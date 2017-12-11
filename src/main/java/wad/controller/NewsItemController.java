/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wad.domain.NewsItem;
import wad.repository.CategoryRepository;
import wad.repository.NewsItemRepository;
import wad.service.NewsService;

/**
 *
 * @author Warva
 */

@Controller
public class NewsItemController {
    
    @Autowired
    private NewsItemRepository newsItemRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/newsitem/{id}")
    public String getNews(@PathVariable Long id, Model model) {
        
        NewsItem newsItem = newsItemRepository.getOne(id);
        newsItem.setLoaded(newsItem.getLoaded()+1);
        
        model.addAttribute("categorys", categoryRepository.findAll());
        
        model.addAttribute("newsItem", newsItem);
        
        model.addAttribute("latest", newsItemRepository.findAll(newsService.latestNews()));
        model.addAttribute("read", newsItemRepository.findAll(newsService.loadedNews()));
        
        return "newsitem";
    }
}
