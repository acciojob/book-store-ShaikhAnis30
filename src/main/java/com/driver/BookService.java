package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(int id){ // NOTE //
        return bookRepository.findBookById(id);
    }

    public String deleteBookById(int id){
        return bookRepository.deleteBookById(id);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findBooksByGenre(String genre){
        return bookRepository.findBooksByGenre(genre);
    }
}
