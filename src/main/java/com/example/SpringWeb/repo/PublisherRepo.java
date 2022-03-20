package com.example.SpringWeb.repo;

import com.example.SpringWeb.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
