package sampleMavenProject.fileHandling;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WriteCsvFile
{
    @Test
    public void testWriteCsvfile() throws IOException
    {
        Path tempsfile = Files.createTempFile("Hello", ".csv");
        File file = tempsfile.toFile();

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) {
            bWriter.write("Welcome, to, my, world\n");
            bWriter.write("How, is, my, world?");

        }

        try(BufferedReader bReader = new BufferedReader(new FileReader(file))){
            String data;
            while ((data = bReader.readLine()) != null) {
                System.out.println(data);
            }
        }
        assertTrue(file.canWrite());
        assertTrue(file.exists());
    }
}