package com.example.SpringWeb.BootStrap;

import com.example.SpringWeb.domain.Author;
import com.example.SpringWeb.domain.Book;
import com.example.SpringWeb.repo.AuthorRepo;
import com.example.SpringWeb.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepo bookRepo;

    @Override
    public void run(String... args) throws Exception {

        Author ram = new Author("ram");
        Author shri = new Author("Shri");

        Book tele = new Book("Tele Coms","124587");
        Book sales = new Book("Sales","458795");

        shri.getBooks().add(sales);
        tele.getAuthors().add(shri);

        authorRepo.save(shri);
        bookRepo.save(tele);

        ram.getBooks().add(tele);
        sales.getAuthors().add(ram);

        authorRepo.save(ram);
        bookRepo.save(sales);

        System.out.println("No.of Authors: "+authorRepo.count());
        System.out.println("No of Books: "+ bookRepo.count());


    }
}
