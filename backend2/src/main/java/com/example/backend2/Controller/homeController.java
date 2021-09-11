package com.example.backend2.Controller;

import com.example.backend2.Entity.Category;
import com.example.backend2.Entity.Users;
import com.example.backend2.Repository.categoryRepository;
import com.example.backend2.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class homeController {
    @Autowired
    categoryRepository catRepo;

    @Autowired
    userRepository userRep;


    @GetMapping("/login")
    public String loginPortal(){
        return "login";
    }

    @GetMapping("/homePage")
    public String home(){return "homePage";}

    @GetMapping("/valid")
    public String valid(@RequestParam String  user_email , @RequestParam String  user_pwd){
      //  System.out.println(a + b);
        String a = user_email;
        String b = user_pwd;
      //  System.out.println(a + " " + b);
        List<Users> alp ;
        alp =  userRep.findByUserNameAndPassword(a ,b);
       // System.out.println(alp);


        if(alp.isEmpty()){
            return "Incorrect";
        }
        return "homePage";
    }

   @GetMapping("/test")
    public String test2(Model model){
        return "test 2";
   }

}

