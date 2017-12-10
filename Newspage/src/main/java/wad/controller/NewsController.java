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
import wad.repository.NewsItemRepository;

/**
 *
 * @author Warva
 */
@Controller
public class NewsController {
    
    @Autowired
    private NewsItemRepository newsItemRepository;
    
    @GetMapping("/")
    public String list(Model model) {
        
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "time");
        model.addAttribute("news", newsItemRepository.findAll(pageable));
        
        return "index";
    }
    
}
