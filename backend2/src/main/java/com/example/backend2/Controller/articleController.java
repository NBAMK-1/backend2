package com.example.backend2.Controller;

import com.example.backend2.Entity.Article;
import com.example.backend2.Entity.Category;
import com.example.backend2.Repository.articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class articleController {

    @Autowired
    articleRepository artRepo;

    @GetMapping("/addArticle")
    public String displayArticle(){
        return "addArticle";
    }

    @GetMapping("/articleShow1")
    public String articleShow1(Model model){
        List<Article> art =artRepo.findAll();
        model.addAttribute("articleList",art);
        return "articleShow";
    }

    @GetMapping("/articleShow")
    public String articleShow(@RequestParam String content , @RequestParam String status,
                               @RequestParam Long category_id, Model model ){
        save1(content, status, category_id);
        List<Article> art =artRepo.findAll();
        model.addAttribute("articleList",art);
        return "addArticle";
    }

    private void save1(String content, String status, Long category_id) {
        Article a = new Article();
        a.setContent(content);
        a.setStatus(status);
        a.setCategory_id(category_id);
        artRepo.save(a);
    }

    @GetMapping("/delete1/{id1}")
    public String  delete1(@PathVariable("id1") Long id){
        Article as = artRepo.getById(id);
        artRepo.delete(as);
        return "redirect:/articleShow1";
    }

    ///////////////////////////////////////
    @GetMapping("/edit1/{id1}")
    public String updateUser(@PathVariable("id1") long id,  Model model) {
        delete2(id);

        return "updateArticle";
    }

    private void delete2(long id) {
        Article a1 = artRepo.getById(id);
        artRepo.delete(a1);
    }

    @GetMapping("/articleShow3")
    public String articleShow3(@RequestParam String content1 , @RequestParam String status1,
                               @RequestParam Long category_id1, Model model ){

        save1( content1, status1, category_id1);
        List<Article> at =artRepo.findAll();
        model.addAttribute("articleList",at);
        return "articleShow";
    }


}
