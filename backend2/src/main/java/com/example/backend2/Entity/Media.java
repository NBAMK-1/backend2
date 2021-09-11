package com.example.backend2.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mid;
    private String media_title;
    private String media_url;
//    @OneToOne
//    @JoinColumn(name = "category")
    private String category;

//    @OneToMany(mappedBy = "catTitle")
//    private List<Category> categoryMedia ;
//
//    public List<Category> getCategoryMedia() {
//        return categoryMedia;
//    }
//
//    public void setCategoryMedia(List<Category> categoryMedia) {
//        this.categoryMedia = categoryMedia;
//    }

    public Media() {
    }

    public Media(String media_title, String media_url, String category) {
        super();
        this.media_title = media_title;
        this.media_url = media_url;
        this.category = category;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMedia_title() {
        return media_title;
    }

    public void setMedia_title(String media_title) {
        this.media_title = media_title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
