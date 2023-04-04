package ee.viigipuu.multidb.controllers

import ee.viigipuu.multidb.model.Book
import ee.viigipuu.multidb.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/{tenant}")
class BookController {

    private final BookService bookService

    BookController(BookService bookService) {
        this.bookService = bookService
    }

    @GetMapping("/books")
    List<Book> getBooks(@PathVariable("tenant") String tenant) {
        bookService.getBooks(tenant)
    }
}
