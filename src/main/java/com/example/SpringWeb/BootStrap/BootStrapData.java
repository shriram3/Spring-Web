package com.example.SpringWeb.BootStrap;

import com.example.SpringWeb.domain.Author;
import com.example.SpringWeb.domain.Book;
import com.example.SpringWeb.domain.Publisher;
import com.example.SpringWeb.repo.AuthorRepo;
import com.example.SpringWeb.repo.BookRepo;
import com.example.SpringWeb.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepo bookRepo;
    @Autowired
    PublisherRepo publisherRepo;

    @Override
    public void run(String... args) throws Exception {

        Publisher eagle = new Publisher("Eagle","Opp. of VOC","Tvl", 989794556);
        Publisher pvt = new Publisher("pvt","Opp. of BT","Tvl", 989954587);

        publisherRepo.save(eagle);
        publisherRepo.save(pvt);

        Author ram = new Author("ram");
        Author shri = new Author("Shri");

        Book tele = new Book("Tele Coms","124587");
        tele.setPublisher(eagle);
        eagle.getBooks().add(tele);

        bookRepo.save(tele);
        publisherRepo.save(eagle);

        Book sales = new Book("Sales","458795");
        sales.setPublisher(pvt);
        pvt.getBooks().add(sales);

        bookRepo.save(sales);
        publisherRepo.save(pvt);

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
        System.out.println("No of Publishers: "+ publisherRepo.count());



    }
}
