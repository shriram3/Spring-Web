package com.example.SpringWeb.Controller;

import com.example.SpringWeb.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepo;

    @RequestMapping("/author")
    public String listAuthor(Model model){

        model.addAttribute("authors", authorRepo.findAll());
        return "Author/list";
    }

}
