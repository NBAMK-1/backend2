package com.example.backend2.Controller;

import com.example.backend2.Entity.Category;
import com.example.backend2.Repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    categoryRepository catRepo;

    @GetMapping("/category")
    public String displayCategory(){
        return "category";
    }

    @GetMapping("/categoryShow")
    public String categoryShow(@RequestParam String  ctitle , Model model ){
        save( ctitle);
        List<Category> cat =catRepo.findAll();
        model.addAttribute("categoryList",cat);
        return "category";
    }
    @GetMapping("/categoryShow1")
    public String categoryShow1(Model model){
        List<Category> cat1 =catRepo.findAll();
        model.addAttribute("categoryList",cat1);
        return "categoryShow";
    }

    private void save( String title) {
        Category cat = new Category();
        cat.setCtitle(title);
        catRepo.save(cat);
    }



    @GetMapping("/delete/{id}")
    public String  delete(@PathVariable("id") Long id){
        Category c = catRepo.getById(id);
        catRepo.delete(c);
        return "redirect:/categoryShow1";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id,  Model model) {
      delete2(id);

        return "updateCategory";
    }

    private void delete2(long id) {
        Category c1 = catRepo.getById(id);
        catRepo.delete(c1);
    }

    @GetMapping("/categoryShow3")
    public String categoryShow3(@RequestParam String  ctitle2 , Model model ){

        save( ctitle2);
        List<Category> cat =catRepo.findAll();
        model.addAttribute("categoryList",cat);
        return "categoryShow";
    }


}
