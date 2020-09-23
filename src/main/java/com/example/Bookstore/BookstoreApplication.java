package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepo) {
		return (args) -> {
			log.info("save a couple of students");
			crepo.save(new Category(""));
			crepo.save(new Category("Sci-Fi"));
			crepo.save(new Category("Classics"));
			crepo.save(new Category("Horror"));
			crepo.save(new Category("Action & Adventure"));
			crepo.save(new Category("Comic Book"));
			crepo.save(new Category("Detective and Mystery"));
			crepo.save(new Category("Fantasy"));
			crepo.save(new Category("Romance"));
			crepo.save(new Category("Short Stories"));
			crepo.save(new Category("Thrillers"));
			crepo.save(new Category("Realism"));
			crepo.save(new Category("Political Satire"));
			crepo.save(new Category("Academic and Professional"));
			
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "123131-321", 10.25,  crepo.findByName("Political Satire").get(0)));
			repository.save(new Book("The Problem of Increasing Human Energy", "Nikola Tesla", 1900, "6543231-121", 45.95,  crepo.findByName("Academic and Professional").get(0)));
			repository.save(new Book("The Alchemist", "Homer", 1993, "1212341-112", 13.55,  crepo.findByName("Fantasy").get(0)));			
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
