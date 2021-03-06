/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewsItem extends AbstractPersistable<Long>{
    
    private String title;
    private LocalDateTime time = LocalDateTime.now();
    private String ingres;
    private String text;
    private Integer loaded = 0;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @ManyToMany
    private List<Writer> writers;
    
    @ManyToMany
    private List<Category> categorys;
    
    public void setWriter(Writer writer) {
        this.writers.add(writer);
    }
    
    public void setCategory(Category category) {
        this.categorys.add(category);
    }
    
    public List<Writer> getWriters() {
        
        if (this.writers == null) {
            this.writers = new ArrayList<>();
        }
        
        return this.writers;
    }
    
    public List<Category> getCategorys() {
        
        if (this.categorys == null) {
            this.categorys = new ArrayList<>();
        }
        
        return this.categorys;
    }
    
}
