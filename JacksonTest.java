package sampleMavenProject.fileHandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Student{

    public String name;
    public String section;
    public String course;

    public Student(){

    }
    public Student(String name,String section,String course){
        this.name=name;
        this.section=section;
        this.course=course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", section=" + section +
                ", course=" + course +
                '}';
    }
}

public class JacksonTest
{
    @Test
    public void testJackson() throws JsonProcessingException
    {
        ObjectMapper jacksonFile=new ObjectMapper();
        Student data=new Student("Bhavya","B","Java full stack");

        String jsonFile= jacksonFile.writeValueAsString(data);
        System.out.println("Serialization: "+jsonFile);

        Student objectFile=jacksonFile.readValue(jsonFile,Student.class);
        System.out.println("Deserialization: "+objectFile);

        assertNotNull(objectFile);
        assertEquals(data.name,objectFile.name);
        assertEquals(data.section,objectFile.section);
        assertEquals(data.course,objectFile.course);
    }
}