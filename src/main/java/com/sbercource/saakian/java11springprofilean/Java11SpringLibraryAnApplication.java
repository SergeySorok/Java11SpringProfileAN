package com.sbercource.saakian.java11springprofilean;

import com.sbercource.saakian.java11springprofilean.database.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Java11SpringLibraryAnApplication implements CommandLineRunner {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Java11SpringLibraryAnApplication(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Java11SpringLibraryAnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        BookDAO bookDAO = new BookDAO();
//        bookDAO.findBookById(1);
//        bookDAO.findBookById(2);
//        bookDAO.findBookByTitle("Недоросль");
//
//        BookDAO2 bookDAO2 = new BookDAO2(DbApp.INSTANCE.newConnection());
//        bookDAO2.findBookById(3);
//        bookDAO2.findBookById(4);
//        bookDAO2.findBookByTitle("Недоросль");
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DatabaseConfig.class);
//        BookDAO2 bookDAO21 = applicationContext.getBean(BookDAO2.class);
//        bookDAO21.findBookById(2);
//        bookDAO21.findBookById(3);

        List<Book> books = jdbcTemplate.query("select * from books",
                (rs, rowNum) -> new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                )
        );
        books.forEach(System.out::println);
    }
}
