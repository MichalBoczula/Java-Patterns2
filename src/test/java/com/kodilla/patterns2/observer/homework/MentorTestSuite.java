package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTestSuite {

    @Test
    public void update() {
        //Given
        final Course aprilCourse = new BootcampApril();
        final Course mayCourse = new BootcampMay();
        final Mentor javaMentor1 = new Mentor("Java Mentor");
        final Mentor javaMentor2 = new Mentor("Java Mentor");
        aprilCourse.registerObserver(javaMentor1);
        aprilCourse.registerObserver(javaMentor2);
        mayCourse.registerObserver(javaMentor1);
        //When
        aprilCourse.addTask("mod 6 task 1");
        aprilCourse.addTask("mod 6 task 2");
        mayCourse.addTask("mod 1 task 2");
        mayCourse.addTask("mod 1 task 2");
        //Then
        assertEquals(4, javaMentor1.getUpdateCount());
        assertEquals(2, javaMentor2.getUpdateCount());
    }
}