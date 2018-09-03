package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.CompanySalaryProcessor;
import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.newhrsystem.SalaryProccesor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProccesor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProccesor = new CompanySalaryProcessor();
        return theProccesor.calculateSalaries(employees);
    }
}
