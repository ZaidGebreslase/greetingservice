package greet.greetingservice.controller;

import greet.greetingservice.domain.Book;
import greet.greetingservice.repository.BookRepository;
import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(BookController.BASE_MAPPING)
public class BookController {

  public static final String BASE_MAPPING = "/";

  private final BookRepository bookRepository;

  @Autowired
  public BookController(BookRepository bookRepository) {

    this.bookRepository = bookRepository;
  }

  @RequestMapping(value = "/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addBook(@RequestParam Book book) {
    bookRepository.save(book);
  }

  @RequestMapping(value= "/book/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> getBook(@PathVariable String id) {
    return new ResponseEntity<>(bookRepository.findById(id).get(), HttpStatus.OK);
  }

  @RequestMapping(value= "/book/{id}", method = RequestMethod.DELETE)
  public void deleteBook(@PathVariable String id) {

    bookRepository.delete(bookRepository.findById(id).get());
  }


  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public ResponseEntity<?> getAllBooks() {

    List<Book> books = Lists.newArrayList(bookRepository.findAll());

    return new ResponseEntity<>(books, HttpStatus.MULTI_STATUS.OK);
  }


}
