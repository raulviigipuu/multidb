package ee.viigipuu.multidb.controllers

import ee.viigipuu.multidb.model.Book
import ee.viigipuu.multidb.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class BookController {

    @Autowired
    BookService bookService

    @GetMapping("/{tenant}/books")
    List<Book> findAllBooks(@PathVariable String tenant) {
        println("TENANT: " + tenant)
        bookService.findAll(tenant)
    }
}
