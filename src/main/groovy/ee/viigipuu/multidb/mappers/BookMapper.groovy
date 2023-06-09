package ee.viigipuu.multidb.mappers

import ee.viigipuu.multidb.model.Book
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface BookMapper {

    @Select("SELECT * FROM books")
    List<Book> findAll(@Param("tenant") String tenant)
}