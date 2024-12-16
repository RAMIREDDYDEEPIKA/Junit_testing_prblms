package sampleMavenProject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulation
{
    StringUtils stringUtils=new StringUtils();

    @Test
    public void reverseString(){
        assertEquals("lufituaeb",stringUtils.reverse("beautiful"));
        assertEquals("hello",stringUtils.reverse("olleh"));
        assertEquals("uoy",stringUtils.reverse("you"));
    }

    @Test
    public void upperCase(){
        assertEquals("HELLO",stringUtils.toUpperCase("hello"));
        assertEquals("HI",stringUtils.toUpperCase("Hi"));
    }

    @Test
    public void palindrome(){
        assertTrue(stringUtils.isPalindrome("Madam"));
        assertTrue(stringUtils.isPalindrome("12321"));
        assertTrue(stringUtils.isPalindrome("Anna"));
        assertTrue(stringUtils.isPalindrome("@^&*&^@"));
    }
}