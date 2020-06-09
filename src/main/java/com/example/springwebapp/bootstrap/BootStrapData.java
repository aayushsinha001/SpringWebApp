package com.example.springwebapp.bootstrap;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.Publisher;
import com.example.springwebapp.repositories.AuthorRepository;
import com.example.springwebapp.repositories.BookRepository;
import com.example.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author authorname = new Author("Mala","Gupta");
        Book bookjava = new Book("Getting Started Java SE8", "0303048948540");
        Publisher publisher = new Publisher("Arihant","CP Delhi India", "Delhi", "UT", "7000001");

        publisherRepository.save(publisher);

        authorname.getBooks().add(bookjava);
        bookjava.getAuthors().add(authorname);

        bookjava.setPublisher(publisher);
        publisher.getBooks().add(bookjava);

        authorRepository.save(authorname);
        bookRepository.save(bookjava);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Number of books for a publisher " + publisher.getBooks().size());


    }
}
