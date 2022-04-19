package com.techelevator.hr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerTests
{

    @Test
    public void hireEmployee_ShouldCreateAnEmployee_AndAddThemToTheDepartment()
    {
        // arrange
        Manager manager = new Manager("Manager", "Managerson");
        Department department = new Department("Test Department");
        manager.setDepartment(department);

        // act
        Employee employee = manager.hireEmployee("Test", "Testerson", "Tester of testing", 50000);

        // assert
        assertEquals("Because the first name of the employee should match who was hired.", "Test", employee.getFirstName());
        assertEquals("Because the last name of the employee should match who was hired.", "Testerson", employee.getLastName());
        assertEquals("Because the title of the employee should match the title of who was hired.", "Tester of testing", employee.getTitle());
        assertEquals("Because the salary of the employee should match who was hired.", 50000, employee.getSalary(), 0.0);
        assertEquals("Because the email of the new employee should include the first initial and last name.", "ttesterson@petelevator.com", employee.getEmail());
        assertEquals("Because the employees department should be the same department as the hiring manager.", department, employee.getDepartment());
        assertTrue("Because the department of the hiring manager should include the new employee.", department.getDepartmentEmployees().contains(employee));
    }
}
