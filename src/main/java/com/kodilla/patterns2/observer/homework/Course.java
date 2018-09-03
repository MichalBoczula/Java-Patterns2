package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Course implements Observable{
    private final List<Observer> observers;
    private final List<String> tasks;
    private final String name;

    public Course(String name) {
        this.tasks = new ArrayList<>();
        this.name = name;
        observers = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(observer -> observer.update(this));
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
