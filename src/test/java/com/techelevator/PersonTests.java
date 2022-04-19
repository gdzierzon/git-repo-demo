package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PersonTests
{

    @Test
    public void getFullName_ShouldReturn_FirstAndLastName()
    {
        // arrange
        Person person = new Person("Test", "Testerson");
        String expected = "Test Testerson";

        // act
        String actual = person.getFullName();

        // assert
        String message ="The full name returned from person is not in the correct format.";
        Assert.assertEquals(message, expected, actual);
    }
}
