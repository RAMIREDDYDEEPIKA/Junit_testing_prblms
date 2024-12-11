package sampleMavenProject;

public class StringUtils
{
    public String reverse(String input)
    {
        StringBuilder dupli=new StringBuilder();
        for(int i=input.length()-1;i>=0;i--)
        {
            dupli.append(input.charAt(i));
        }
        return dupli.toString();
    }

    public String toUpperCase(String input)
    {
        return input.toUpperCase();
    }

    public boolean isPalindrome(String input)
    {
        String inputUpper=input.toUpperCase();
        StringBuilder duplicate=new StringBuilder();
        for(int i=inputUpper.length()-1;i>=0;i--)
        {
            duplicate.append(inputUpper.charAt(i));
        }
        return inputUpper.equals(duplicate.toString());
    }
}