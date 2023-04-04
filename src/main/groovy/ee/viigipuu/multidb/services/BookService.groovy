package ee.viigipuu.multidb.services

import ee.viigipuu.multidb.mappers.BookMapper
import ee.viigipuu.multidb.model.Book
import org.springframework.stereotype.Service

@Service
class BookService {

    final BookMapper bookMapper

    BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper
    }

    List<Book> findAll(String tenant) {
        return bookMapper.findAllBooksForTenant(tenant)
    }
}
