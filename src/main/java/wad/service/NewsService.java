/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wad.domain.Category;
import wad.domain.Writer;
import wad.repository.CategoryRepository;
import wad.repository.WriterRepository;

/**
 *
 * @author Warva
 */
@Service
public class NewsService {
    
    private Pageable pageable;
    private Category category;
    private Writer writer;
    
    @Autowired
    private WriterRepository writerRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Pageable latestNews() {
        pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "time");
        return pageable;
    }
    
    public Pageable loadedNews() {
        pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "loaded");
        return pageable;
    }
    
    public void addWriter() {
        
        if(writerRepository.findByName("Mikko")== null) {
            writer = new Writer();
            writer.setName("Mikko");
            writerRepository.save(writer);
        }
        
        if(writerRepository.findByName("Sanni")== null) {
            writer = new Writer();
            writer.setName("Sanni");
            writerRepository.save(writer);
        }
        
        if(writerRepository.findByName("Jenna")== null) {
            writer = new Writer();
            writer.setName("Jenna");
            writerRepository.save(writer);
        }
    }
    
    public void addCategory() {
        
        if(categoryRepository.findByName("Kotimaa")== null) {
            category = new Category();
            category.setName("Kotimaa");
            categoryRepository.save(category);
            
        }
        
        if(categoryRepository.findByName("Ulkomaat")== null) {
            category = new Category();
            category.setName("Ulkomaat");
            categoryRepository.save(category);
        }
        
        if(categoryRepository.findByName("Politiikka")== null) {
            category = new Category();
            category.setName("Politiikka");
            categoryRepository.save(category);
        }
    }
    
}
