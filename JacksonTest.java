package sampleMavenProject.fileHandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Student {
    public String name;
    public String section;
    public String course;

    public Student() {
    }

    public Student(String name, String section, String course) {
        this.name = name;
        this.section = section;
        this.course = course;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", section='" + section + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

public class JacksonTest {

    private final File jsonFile = new File("student.json");

    private void createJsonFile(Student student) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jsonFile, student);
    }

    public void serializeToJson(Student student) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(student);
        objectMapper.writeValue(jsonFile, student);
        System.out.println("Serialized Data: " + jsonData);
    }

    public Student deserializeFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonFile, Student.class);
    }

    @Test
    public void testSerialization() throws IOException {
        Student student = new Student("Bhavya", "B", "Java full stack");

        serializeToJson(student);

        assertNotNull(jsonFile);
        assertEquals(true, jsonFile.exists());
    }

    @Test
    public void testDeserialization() throws IOException {
        Student deserializedStudent = deserializeFromJson();

        assertNotNull(deserializedStudent);
        assertEquals("Bhavya", deserializedStudent.name);
        assertEquals("B", deserializedStudent.section);
        assertEquals("Java full stack", deserializedStudent.course);

        System.out.println("Deserialization : " + deserializedStudent);
    }
}