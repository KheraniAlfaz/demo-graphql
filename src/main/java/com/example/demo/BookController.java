package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class BookController {
    private final Logger logger = Logger.getLogger(BookController.class.getName());

    @QueryMapping
    public Book bookById(@Argument String id) {
        logger.info("Request Accepted");
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}
