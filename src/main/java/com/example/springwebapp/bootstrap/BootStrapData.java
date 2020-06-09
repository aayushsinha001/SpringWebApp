package com.example.springwebapp.bootstrap;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.repositories.AuthorRepository;
import com.example.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author gosling = new Author("James","Gosling");
        Book java = new Book("Getting Started Java", "0303048948540");
        gosling.getBooks().add(java);
        java.getAuthors().add(gosling);

        authorRepository.save(gosling);
        bookRepository.save(java);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books : " + bookRepository.count());
    }
}
