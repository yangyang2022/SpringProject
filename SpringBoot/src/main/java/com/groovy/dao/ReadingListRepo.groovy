package com.groovy.dao

import com.groovy.model.Book
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
//@Repository
class ReadingListRepo implements IReadingList {

//    @Autowired
    private JdbcTemplate jdbc;


    @Override
    List<Book> findByReader(String reader) {
        String sql = "select id,reader,isbn,title,author,description from Book where reader=?";
        jdbc.query(
                sql,
                {
                    rs,row -> new Book(
                            id: rs.getLong(1),
                            reader: rs.getString(2),
                            isbn: rs.getString(3),
                            title: rs.getString(4),
                            author: rs.getString(5),
                            description: rs.getString(6)
                    ) as RowMapper
                } ,
                reader
        )
    }

    @Override
    void save(Book book) {
        String sql ="insert into Book (reader,isbn,title,author,reader)values(?,?,?,?,?)"
        jdbc.update(sql,book.reader,book.isbn,book.title,book.author,book.description)
    }
}
