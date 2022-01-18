/*
package com.training.libraryservice;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.libraryservice.entity.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PutBookTest extends LibraryTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("book-service", "localhost", 8585, this);

    @Pact(provider = "book-service",consumer = "library-service")
    public RequestResponsePact createPactForPut(PactDslWithProvider builder) throws JsonProcessingException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        Book book = new Book();
        book.setBookid(1L);
        book.setTitle("update pact1");
        book.setAuthor("update");
        book.setGenre("study");
        book.setIsbn("978465313131");
        book.setPrice(88);
        return builder
                .uponReceiving("PUT REQUEST")
                .method("PUT")
                .headers(headers)
                .body(super.mapToJson(book))
                .path("/books/1")
                .willRespondWith()
                .status(201)
                .headers(headers)
                .body(super.mapToJson(book))
                .toPact();
    }

    @Test
    @PactVerification("book-service")
    public void testPutBook() throws Exception {
        Book book = new Book();
        book.setBookid(1L);
        book.setTitle("update pact1");
        book.setAuthor("update");
        book.setGenre("study");
        book.setIsbn("978465313131");
        book.setPrice(88);
        String inputJson = super.mapToJson(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json");
        ResponseEntity<Book> postResponse = new RestTemplate().exchange(mockProvider.getUrl()+"/books/1",
                HttpMethod.PUT,
                new HttpEntity<>(inputJson,headers),
                Book.class);
        assertEquals(book.getBookid(),postResponse.getBody().getBookid());
    }

}
*/
