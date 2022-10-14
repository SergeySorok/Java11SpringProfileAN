package com.sbercource.saakian.java11springprofilean.database.dao;

import com.sbercource.saakian.java11springprofilean.database.DbApp;
import com.sbercource.saakian.java11springprofilean.database.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    public Book findBookById(final Integer id) throws SQLException {
        try (Connection connection = DbApp.INSTANCE.newConnection()) {

            PreparedStatement selectQuery = connection.prepareStatement(
                    "select * from books where id = ?");
            selectQuery.setInt(1, id);
            ResultSet resultSet = selectQuery.executeQuery();
            return getBook(resultSet);
        }
    }

    public Book findBookByTitle(final String title) throws SQLException {
        try (Connection connection = DbApp.INSTANCE.newConnection()) {
            PreparedStatement selectQuery = connection.prepareStatement(
                    "select * from books where title = ?"
            );
            selectQuery.setString(1, title);
            ResultSet resultSet = selectQuery.executeQuery();
            return getBook(resultSet);
        }
    }

    private Book getBook(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt(1));
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setDate(resultSet.getString("date_added"));
            System.out.println(book);
            return book;
        }
        return null;
    }
}
