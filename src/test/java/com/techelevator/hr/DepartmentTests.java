package com.techelevator.hr;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentTests
{

    @Test
    public void transferEmployeeIn_ShouldMoveAnEmployee_FromOneDepartment_IntoAnother()
    {
        // arrange
        Department oldDept = new Department("Old Department");
        Department newDept = new Department("New Department");

        Employee employee = new Employee("Test", "Test");
        employee.setDepartment(oldDept);

        // act
        newDept.transferEmployeeIn(employee);

        // assert
        List<Employee> oldDeptEmployees = oldDept.getDepartmentEmployees();
        List<Employee> newDeptEmployees = newDept.getDepartmentEmployees();

        String message = "The Old Department size should be 0, because the employee should have been transferred out of the Old Department.";
        assertEquals(message, 0, oldDeptEmployees.size());

        message = "The New Department size should be 1, because the employee should have been transferred into the New Department.";
        assertEquals(message, 1, newDeptEmployees.size());

        message = "Because the New Department employee list should contain the transferred employee.";
        assertTrue(message, newDeptEmployees.contains(employee));
    }

    @Test
    public void setDepartmentHead_ShouldAcceptAManager_WithManagerInTheirTitle()
    {
        // arrange
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Manager of Testing", 100000);

        // act
        department.setDepartmentHead(manager);

        // assert
        String message = "Because a manager with 'Manager' in the title should be accepted as a department head.";
        assertEquals(message, manager, department.getDepartmentHead());
    }

    @Test
    public void setDepartmentHead_ShouldAcceptAManager_WithDirectorInTheirTitle()
    {
        // arrange
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Director of Testing", 100000);

        // act
        department.setDepartmentHead(manager);

        // assert
        String message = "Because a manager with 'Directory' in the title should be accepted as a department head.";
        assertEquals(message, manager, department.getDepartmentHead());
    }

    @Test
    public void setDepartmentHead_ShouldNotAcceptAManager_WithAnImproperTitle()
    {
        // arrange
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Head of Testing", 100000);

        // act
        department.setDepartmentHead(manager);

        // assert
        String message = "Because the manager title does not start with 'Manager' or 'Director' they should not be accepted as a department head.";
        assertNull(message, department.getDepartmentHead());
        message = "Because the manager title does not start with 'Manager' or 'Director' they should not have been added as the department head.";
        assertNotEquals(message, manager, department.getDepartmentHead());
    }
}
