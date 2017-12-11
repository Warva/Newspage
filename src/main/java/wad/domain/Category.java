/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Warva
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category extends AbstractPersistable<Long>{
    
    private String name;
    
    @ManyToMany(mappedBy = "categorys", fetch=FetchType.EAGER)
    private List<NewsItem> news;
    
    public List<NewsItem> getNews() {
        
        if (this.news == null) {
            this.news = new ArrayList<>();
        }
        
        return this.news;       
    }
    
    public void setNews(NewsItem newsItem) {
        this.news.add(newsItem);
    }

}
