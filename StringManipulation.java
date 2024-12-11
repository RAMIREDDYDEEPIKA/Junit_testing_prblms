package sampleMavenProject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulation
{
    StringUtils stringUtils=new sampleMavenProject.StringUtils();

    @Test
    public void reverseString(){
        String input="hello";
        assertEquals("olleh",stringUtils.reverse(input));
    }

    @Test
    public void upperCase(){
        String input="hello";
        assertEquals("HELLO",stringUtils.toUpperCase(input));
    }

    @Test
    public void palindrome(){
        String input="madam";
        assertTrue(stringUtils.isPalindrome(input));
    }
}