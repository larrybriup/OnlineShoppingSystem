package com.eagle.dao;

import java.util.List;

import com.eagle.bean.Book;

public interface IBookDao {
	List<Book> findAllBooks() throws Exception;
}
