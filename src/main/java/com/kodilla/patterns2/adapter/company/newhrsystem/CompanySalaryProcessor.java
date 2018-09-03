package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProccesor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Employee employee : employees){
            sum = sum.add(employee.getSalary());
        }
        return sum;
    }
}
