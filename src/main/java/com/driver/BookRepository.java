package com.driver;
import java.lang.reflect.Array;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    // map id with Book
    Map<Integer, Book> db;

    private int bookId;


    public BookRepository(){
        db = new HashMap<Integer, Book>();
        this.bookId = 0;
    }

    public Book save(Book book){
        this.bookId++;
        book.setId(this.bookId);
        db.put(this.bookId, book);
        return book;
    }

    public Book findBookById(int id){
        if(db.containsKey(id)) {
            return db.get(id);
        }
        return null;
    }

    public List<Book> findAll(){
        return new ArrayList<>(db.values());
//        ArrayList<Book> bookList = new ArrayList<Book>();
//        for (Book book : db.values()) {
//            bookList.add(book);
//        }
//        return bookList;
    }

    public String deleteBookById(int id){
        if(db.containsKey(id)) {
            db.remove(id);
            return "Book Deleted";
        }else
            return null;
    }

    public void deleteAll(){
        db.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books = new ArrayList<Book>();
        for (Book book : db.values()) {
            if(book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books = new ArrayList<Book>();
        for (Book book : db.values()) {
            if(book.getGenre().equals(genre)) {
                books.add(book);
            }
        }
        return books;
    }
}
