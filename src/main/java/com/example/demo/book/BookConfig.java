package com.example.demo.book;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookConfig {

  @Bean
  CommandLineRunner commandLineRunner(BookRepository repository) {
    return args -> {
      try {
        Faker faker = new Faker();

        List<Book> books = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
          books.add(new Book(faker.book().author(), faker.lorem()
                  .sentences(5)
                  .stream().reduce("", String::concat), faker.book()
                  .publisher(), faker.cat()
                  .breed(), faker.book().title(), faker.bool().bool(), faker.number().numberBetween(1, 5)));
        }

        repository.saveAll(books);

      } catch (Exception e) {
        System.err.println(e);
      }

    };
  }
}
