package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian() {
        //Given
        final MedianAdapter medianAdapter = new MedianAdapter();
        final Book book1 = new Book("A", "A", 2000, "1");
        final Book book2 = new Book("B", "B", 2001, "2");
        final Book book3 = new Book("C", "C", 2001, "3");
        final Book book4 = new Book("D", "D", 2002, "4");
        final Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        //When
        int testValue = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2001, testValue);
    }
}