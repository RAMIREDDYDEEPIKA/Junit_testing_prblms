package sampleMavenProject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckEvenNum
{
    public boolean isEven(int number){
        return number%2==0;
    }
    @ParameterizedTest
    @ValueSource(ints={2,4,6,8})
    public void checkEven(int number){
        assertTrue(isEven(number));
    }
}