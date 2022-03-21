package com.example.SpringWeb.Controller;


import com.example.SpringWeb.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepo.findAll());
        return "Books/list";
    }
}
