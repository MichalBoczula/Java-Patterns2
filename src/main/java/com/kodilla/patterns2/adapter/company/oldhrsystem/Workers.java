package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"1", "John", "Smith"},
            {"2", "Ivona", "Novak"},
            {"3", "Jessie", "Pinkman"},
            {"4", "Walter", "White"},
            {"5", "Clara", "Lanson"}};
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00};

    private String getWorkers(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
