/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.NewsItem;
import wad.repository.CategoryRepository;
import wad.repository.NewsItemRepository;
import wad.repository.WriterRepository;

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
    private WriterRepository writeRepository;
    
    @GetMapping("/manage")
    public String get() {
        return "manage";
    }
    
    @PostMapping("/manage")
    public String addNews(@RequestParam String title, @RequestParam String ingres, @RequestParam String text,
            @RequestParam("picture") MultipartFile picture) throws IOException {

        NewsItem newsItem = new NewsItem();
        newsItem.setTitle(title);
        newsItem.setIngres(ingres);
        newsItem.setText(text);
        newsItem.setPicture(picture.getBytes());
        
        newsItemRepository.save(newsItem);
        return "redirect:/";
    }
    
    @PutMapping("/manage")
    public String editNews() {
        
        return "redirect:/";
    }
    
}
