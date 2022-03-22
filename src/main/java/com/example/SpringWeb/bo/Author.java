package com.example.SpringWeb.bo;

import lombok.Data;

@Data
public class Author {

    private long id;
    private String name;

    @Override
    public String toString() {
        return "Author details{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
