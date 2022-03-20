package com.example.SpringWeb.repo;

import com.example.SpringWeb.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
