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
import org.springframework.web.bind.annotation.PathVariable;
import wad.repository.NewsItemRepository;

/**
 *
 * @author Warva
 */

@Controller
public class NewsItemController {
    
    @Autowired
    private NewsItemRepository newsItemRepository;
    
    @GetMapping("/newsitem/{id}")
    public String getNews(@PathVariable Long id, Model model) {
        
        
        
        return "newsitem";
    }
}
