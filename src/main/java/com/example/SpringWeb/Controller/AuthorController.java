package com.example.SpringWeb.Controller;

import com.example.SpringWeb.domain.Author;
import com.example.SpringWeb.repo.AuthorRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Optional;

@RestController
@RequestMapping(AuthorController.BASE_URL)
public class AuthorController {

    public static final String BASE_URL = "/api";
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ObjectMapper objectMapper;

//    @GetMapping("/author")
//    public String listAuthor(Model model){
//
//        model.addAttribute("authors", authorRepo.findAll());
//        return "Author/list";
//    }

    @GetMapping("/authors")
    public Iterable<Author> displayAuthors(){
        return authorRepo.findAll();
    }

    @GetMapping("/authors-no")
    public int countAuthors(){
        return (int) authorRepo.count();
    }

    @GetMapping("/{id}")
    public Optional<Author> getCustomerId(@PathVariable Long id){
        return authorRepo.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return authorRepo.save(author);
    }

    // Json Mapping to  Author BO

    @RequestMapping(
            value = "/ex/foos",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE },
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<String> print(@RequestBody String request){
        com.example.SpringWeb.bo.Author a = new com.example.SpringWeb.bo.Author();
        try {
            a = objectMapper.readValue(request, com.example.SpringWeb.bo.Author.class);
        }
        catch(JsonProcessingException e){
            System.out.println(e);
        }
        System.out.println(a.toString());

        return ResponseEntity.ok("response");
    }

}
