package ee.viigipuu.multidb.services

import ee.viigipuu.multidb.mappers.BookMapper
import ee.viigipuu.multidb.model.Book
import org.springframework.stereotype.Service

@Service

class BookService {

    private final BookMapper bookMapper

    BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper
    }

    List<Book> getBooks(String tenant) {
        return bookMapper.findAll(tenant)
    }
}
