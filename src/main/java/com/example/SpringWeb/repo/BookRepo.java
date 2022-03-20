package com.example.SpringWeb.repo;

import com.example.SpringWeb.domain.Author;
import com.example.SpringWeb.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
