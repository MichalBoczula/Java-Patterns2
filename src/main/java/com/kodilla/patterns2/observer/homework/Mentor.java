package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(Course course) {
        System.out.println((username + ": New message in topic " + course.getName())
                + "\ntotal: " + course.getTasks().size() + " " + isMoreThanOneTask(course));
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    private String isMoreThanOneTask(Course course) {
        if (course.getTasks().size() > 1) {
            return "tasks";
        } else {
            return "task";
        }
    }
}
