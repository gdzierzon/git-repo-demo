package com.techelevator.hr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests
{

    @Test
    public void getFullName_ShouldReturns_LastNameCommaFirstName()
    {
        // arrange
        Employee employee = new Employee("Test", "Testerson");

        // act
        String fullName = employee.getFullName();

        // assert
        String message = "Because an Employees full name should be displayed with the lastname first.";
        assertEquals(message, "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_ShouldIncreaseTheSalary_WhenPercentIsPositive()
    {
        // arrange
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        double expected = 100 * 1.05;

        // act
        employee.raiseSalary(5);

        // assert
        String message = "Because the salary of 100 should have been raised by %5.";
        assertEquals(message, expected, employee.getSalary(), 0.0);
    }

    @Test
    public void raiseSalaryTest_ShouldNotChangeTheSalary_WhenThePercentIsNegative()
    {
        // arrange
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        double expected = 100;

        // act
        employee.raiseSalary(-10); //"raise" by negative 10%

        // arrange
        String message = "Because the salary of 100 should not change with a negative increase of %-10.";
        assertEquals(message, expected, employee.getSalary(), 0.0);
    }
}
