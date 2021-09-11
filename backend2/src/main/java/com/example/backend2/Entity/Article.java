package com.example.backend2.Entity;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;
    private String content;
    private String status;
//    @ManyToOne
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
    private Long category_id;

    public Article() {
    }

    public Article(String content, String status, Long category_id) {
        super();
        this.content = content;
        this.status = status;
        this.category_id = category_id;
    }

    public Article(String content, String status) {
        super();
        this.content = content;
        this.status = status;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
