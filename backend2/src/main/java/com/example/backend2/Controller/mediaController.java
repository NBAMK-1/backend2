package com.example.backend2.Controller;

import com.example.backend2.Entity.Category;
import com.example.backend2.Entity.Media;

import com.example.backend2.Repository.mediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mediaController {


    @Autowired
    mediaRepository medRepo;

    @GetMapping("/addMedia")
    public String displayArticle(){
        return "addMedia";
    }

    @GetMapping("/mediaShow1")
    public String articleShow1(Model model){
        List<Media> med =medRepo.findAll();
        model.addAttribute("mediaList",med);
        return "mediaShow";
    }

    @GetMapping("/mediaShow")
    public String articleShow( @RequestParam String title , @RequestParam String media_url,
                               @RequestParam String category,Model model ){
        save2(title,media_url,category);
        List<Media> med =medRepo.findAll();
        model.addAttribute("mediaList",med);
        return "addMedia";
    }

    private void save2(String t , String murl ,String cate) {
        Media m =  new Media();
        m.setMedia_title(t);
        m.setMedia_url(murl);
        m.setCategory(cate);
        medRepo.save(m);
    }

    @GetMapping("/delete2/{id2}")
    public String  delete2(@PathVariable("id2") Long id){
        Media m = medRepo.getById(id);
        medRepo.delete(m);
        return "redirect:/mediaShow1";
    }
////////
    @GetMapping("/edit2/{id2}")
    public String updateUser(@PathVariable("id2") long id,  Model model) {
        delete3(id);

        return "updateMedia";
    }

    private void delete3(long id) {
       Media m1 = medRepo.getById(id);
        medRepo.delete(m1);
    }
//
    @GetMapping("/mediaShow3")
    public String categoryShow3( @RequestParam String title1 , @RequestParam String media_url1,
                                 @RequestParam String category1,Model model ){

        save2(title1,media_url1,category1);
        List<Media> mat =medRepo.findAll();
        model.addAttribute("mediaList",mat);
        return "mediaShow";
    }
}
