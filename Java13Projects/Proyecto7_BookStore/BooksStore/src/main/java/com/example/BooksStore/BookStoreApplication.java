package com.example.BooksStore;

import com.example.BooksStore.view.BookForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contextSpring = new SpringApplicationBuilder(BookStoreApplication.class).headless(false).web(WebApplicationType.NONE).run(args);
		EventQueue.invokeLater(() -> {
			BookForm bookForm = contextSpring.getBean(BookForm.class);
			bookForm.setVisible(true);
			//SpringApplication.run(BookStoreApplication.class, args);
		});
	}

}

// TODO: Make changes not instant, add a button like SAVE to save changes to db
