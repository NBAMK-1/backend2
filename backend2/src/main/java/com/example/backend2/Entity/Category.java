package com.example.backend2.Entity;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @OneToOne(mappedBy = "category_id")
    private Long cid;

//    ManyToOne()
//    @JoinColumn("catTitle")
    private String  ctitle;


//    @ManyToOne(cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
//    @JoinColumn(name = "category")
//    private Media catTitle;
//
//    public Media getCatTitle() {
//        return catTitle;
//    }
//
//    public void setCatTitle(Media catTitle) {
//        this.catTitle = catTitle;
//    }

    // @OneToMany(mappedBy = "category")
   // private Category cat;
    public Category() {
    }



    public Category(String ctitle) {
        super();
        this.ctitle = ctitle;
    }

    public Category(Long cid, String ctitle) {
        this.cid = cid;
        this.ctitle = ctitle;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }
}
