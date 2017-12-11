/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.repository.CategoryRepository;
import wad.repository.NewsItemRepository;
import wad.service.NewsService;

/**
 *
 * @author Warva
 */
@Controller
public class NewsController {
    
    @Autowired
    private NewsItemRepository newsItemRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/")
    public String listNews(Model model) {
        
        newsService.addCategory();
       
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("latest", newsItemRepository.findAll(newsService.latestNews())); 
        model.addAttribute("read", newsItemRepository.findAll(newsService.loadedNews()));
        
        return "index";
    }
    
}
