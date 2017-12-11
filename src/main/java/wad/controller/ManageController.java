/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Category;
import wad.domain.NewsItem;
import wad.domain.Writer;
import wad.repository.CategoryRepository;
import wad.repository.NewsItemRepository;
import wad.repository.WriterRepository;
import wad.service.NewsService;

/**
 *
 * @author Warva
 */
@Controller
public class ManageController {
    
    @Autowired
    private NewsItemRepository newsItemRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private WriterRepository writerRepository;
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/manage")
    public String getPage(Model model) {
        
        newsService.addCategory();
        newsService.addWriter();
        
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("writers", writerRepository.findAll());
        model.addAttribute("news", newsItemRepository.findAll());
        return "manage";
    }
    
    @PostMapping("/manage")
    public String addNews(@RequestParam String title, @RequestParam String ingres, @RequestParam String text,
            @RequestParam("picture") MultipartFile picture, 
            @RequestParam List<String> category, @RequestParam List<String> writer) throws IOException {

        NewsItem newsItem = new NewsItem();
        newsItem.setTitle(title);
        newsItem.setIngres(ingres);
        newsItem.setText(text);
        newsItem.setPicture(picture.getBytes());
        
        int i;
        
        for(i=0; i<writer.size(); ++i) {
            Writer writer1 = new Writer();
            writer1.setName(writer.get(i)); 
            newsItem.setWriter(writer1);
        }
        
        for(i=0; i<category.size(); ++i) {
            Category category1 = new Category();
            category1.setName(category.get(i)); 
            newsItem.setCategory(category1);
        }

        newsItemRepository.save(newsItem);
        return "redirect:/manage";
    }
    
    @PutMapping("/manage")
    public String editNews() {
        
        return "redirect:/manage";
    }
    
}
