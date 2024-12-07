package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book updateBook(int bookId, Book bookDetails) {
        Book existingBook = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setGenre(bookDetails.getGenre());
        existingBook.setPrice(bookDetails.getPrice());
        existingBook.setPublishedYear(bookDetails.getPublishedYear());

        return bookRepository.save(existingBook);
    }
}

