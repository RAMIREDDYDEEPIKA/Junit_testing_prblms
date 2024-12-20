package sampleMavenProject.fileHandling;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadCsvFile
{
    @Test
    public void testReadFile() throws IOException
    {
        File file=new File("Student.csv");
        try(BufferedReader bReader=new BufferedReader(new FileReader(file)))
        {
            String data;
            while((data=bReader.readLine())!=null){
                System.out.println(data);
            }
        }
        assertTrue(file.canRead());
        assertTrue(file.exists());
    }
}