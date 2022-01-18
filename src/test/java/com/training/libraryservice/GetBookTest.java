/*
package com.training.libraryservice;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.libraryservice.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.context.TestComponent;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


@TestComponent
public class GetBookTest extends  LibraryTest{

	@Before
	public void setUp() {
		super.setUp();
	}

	@Rule
	public PactProviderRuleMk2 mockProvider
			= new PactProviderRuleMk2("book-service", "localhost", 8585, this);

	@Pact(provider = "book-service",consumer = "library-service")
	public RequestResponsePact createPactForGet(PactDslWithProvider builder) throws JsonProcessingException {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		Book book = new Book();
		book.setBookid(2L);
		book.setTitle("harry potter and prisoner of azkaban");
		book.setAuthor("j.k rowling");
		book.setGenre("fantasy");
		book.setIsbn("5754748745sd4s");
		book.setPrice(55.22);
		return builder
				.uponReceiving("GET REQUEST")
				.path("/books/2")
				.method("GET")
				.willRespondWith()
				.status(200)
				.headers(headers)
				.body(super.mapToJson(book))
				.toPact();
	}


	@Test
	@PactVerification("book-service")
	public void testGetBookFromBookService() throws IOException{
		Book book = new Book();
		book.setBookid(2L);
		book.setTitle("harry potter and prisoner of azkaban");
		book.setAuthor("j.k rowling");
		book.setGenre("fantasy");
		book.setIsbn("5754748745sd4s");
		book.setPrice(55.22);

		Book response = new RestTemplate().getForObject(mockProvider.getUrl()+"/books/2",Book.class);
		Assert.assertEquals(response.getBookid(),book.getBookid());
	}


}
*/
