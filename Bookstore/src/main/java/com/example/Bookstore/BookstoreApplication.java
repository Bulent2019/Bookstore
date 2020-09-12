package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("Odyssey", "Homer", -566, "123231-121", 8.45));
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123243-121", 12.25));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "123131-321", 10.25));
			repository.save(new Book("The Problem of Increasing Human Energy", "Nikola Tesla", 1900, "6543231-121", 45.95));
			repository.save(new Book("The Alchemist", "Homer", 1993, "1212341-112", 13.55));			
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
