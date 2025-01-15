package com.polarbookshop.catalogservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.polarbookshop.catalogservice.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import	static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webtestclient;


	@Test
	void whenPostRequestThenBookCreated() {
		var expectedBook = new Book("1234567891","Title","Author",9.9);

		webtestclient.post().uri("/books").bodyValue(expectedBook).exchange().expectStatus().isCreated().expectBody(Book.class).value(actualBook-> {assertThat(actualBook).isNotNull();
		assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
		});
	}

}
