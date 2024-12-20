package sampleMavenProject.fileHandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CSVUtils {

    public static void writeCsv(String filePath, String[] headers, String[][] data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            writer.writeNext(headers);

            for (String[] row : data) {
                writer.writeNext(row);
            }
        }
    }

    public static List<String[]> readCsv(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }
}

public class CSVUtilsTest {

    String filePath = "Student.csv";
    @BeforeEach
    public void setUp() {

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testWriteAndReadCsv() throws IOException, CsvException {

        String[] headers = {"Name", "Course", "City"};
        String[][] data = {
                {"Janu", "Java", "Bangalore"},
                {"Pooji", "Python", "Hyderabad"},
                {"Dora", "DotNet", "Noida"}
        };

        CSVUtils.writeCsv(filePath, headers, data);

        List<String[]> readData = CSVUtils.readCsv(filePath);

        assertArrayEquals(headers, readData.get(0));

        assertArrayEquals(new String[]{"Janu", "Java", "Bangalore"}, readData.get(1));
        assertArrayEquals(new String[]{"Pooji", "Python", "Hyderabad"}, readData.get(2));
        assertArrayEquals(new String[]{"Dora", "DotNet", "Noida"}, readData.get(3));
    }
}