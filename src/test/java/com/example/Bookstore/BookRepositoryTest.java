package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repo;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repo.findByTitle("Animal Farm");
		System.out.println("OK");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle().contains("Animal"));
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Mickey's Adventures", "Walt Disney", 1945, "6666666-999", 6.99,  new Category("Comic"));
		repo.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
