package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book response = bookService.createBook(book);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity findBookById(@PathVariable("id") int id) {
        Book response = bookService.findBookById(id);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity findAll(){
        List<Book> response = bookService.findAll();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book Deleted", HttpStatus.GONE);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAll() {
        bookService.deleteAll();
        return new ResponseEntity<>("All Books Deleted", HttpStatus.GONE);
    }

    @GetMapping("/get-books-by-author")               // author name plus which book of that author(book name)
    public ResponseEntity findBooksByAuthor(@RequestParam("author") String author){
        List<Book> response = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam("genre") String genre){
        List<Book> response = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }



}
