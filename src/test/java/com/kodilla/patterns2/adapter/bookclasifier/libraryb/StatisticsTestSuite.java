package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StatisticsTestSuite {

    private Statistics statistics;
    private Map<BookSignature, Book> booksMap;

    @Before
    public void init() {
        final Book book1 = new Book("A", "A", 2000);
        final Book book2 = new Book("B", "B", 2001);
        final Book book3 = new Book("C", "C", 2001);
        final Book book4 = new Book("D", "D", 2002);
        final BookSignature bookSignature1 = new BookSignature("1");
        final BookSignature bookSignature2 = new BookSignature("2");
        final BookSignature bookSignature3 = new BookSignature("3");
        final BookSignature bookSignature4 = new BookSignature("4");
        statistics = new Statistics();
        booksMap = new HashMap<>();
        booksMap.put(bookSignature1, book1);
        booksMap.put(bookSignature2, book2);
        booksMap.put(bookSignature3, book3);
        booksMap.put(bookSignature4, book4);
    }

    @Test
    public void averagePublicationYear() {
        //given
        //init
        //when
        int testInt = statistics.averagePublicationYear(booksMap);
        //then
        assertEquals(2001, testInt);
    }

    @Test
    public void medianPublicationYear() {
        //given
        //init
        //when
        int testInt = statistics.medianPublicationYear(booksMap);
        //then
        assertEquals(2001, testInt);
    }
}