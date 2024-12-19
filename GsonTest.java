package sampleMavenProject.fileHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Person{
    String name;
    String address;
    String phnNum;
    public Person(String name,String address,String phnNum){
        this.name=name;
        this.address=address;
        this.phnNum=phnNum;
    }
}
public class GsonTest {

    @Test
    public void testingGsonFile() throws IOException {

        Path gsonFile=Files.createTempFile("Persons",".json");
        System.out.println("path of file: "+gsonFile.toAbsolutePath());

        Person person=new Person("Pooji","Bangalore","247964082469");

        Gson personFile=new GsonBuilder().setPrettyPrinting().create();
        String jsonFile= personFile.toJson(person);

        try(BufferedWriter bWriter=new BufferedWriter(new FileWriter(gsonFile.toFile()))){
            bWriter.write(jsonFile);
        }

        System.out.println("File reading:");
        try(BufferedReader bReader=new BufferedReader(new FileReader(gsonFile.toFile()))){
            String data;
            while((data=bReader.readLine())!=null){
                System.out.println(data);
            }
        }

        assertTrue(gsonFile.toFile().exists());

        Person deserialize=personFile.fromJson(jsonFile.toString(), Person.class);
        System.out.println("\nDeserialization : "+deserialize.name+" , "+deserialize.address+" , "+deserialize.phnNum);
    }
}