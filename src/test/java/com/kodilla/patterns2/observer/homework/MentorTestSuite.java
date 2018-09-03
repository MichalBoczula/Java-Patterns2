package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTestSuite {

    @Test
    public void update() {
        //Given
        final Course aprilCourse = new BootcampApril();
        final Course mayCourse = new BootcampMay();
        final Mentor javaMentor = new Mentor("Java Mentor");
        aprilCourse.registerObserver(javaMentor);
        mayCourse.registerObserver(javaMentor);
        //When
        aprilCourse.addTask("mod 6 task 1");
        aprilCourse.addTask("mod 6 task 2");
        mayCourse.addTask("mod 1 task 2");
        mayCourse.addTask("mod 1 task 2");
        //Then
        assertEquals(4, javaMentor.getUpdateCount());
    }
}