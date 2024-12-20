package sampleMavenProject.fileHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Person {
    String name;
    String address;
    String phnNum;

    public Person(String name, String address, String phnNum) {
        this.name = name;
        this.address = address;
        this.phnNum = phnNum;
    }
}

public class GsonTest {

    private final Path jsonFilePath = Paths.get("person.json");

    private void createJsonFile() throws IOException {
        if (!jsonFilePath.toFile().exists()) {
            jsonFilePath.toFile().createNewFile();
        }
    }

    private void serializeToJson(Person person) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonData = gson.toJson(person);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath.toFile()))) {
            writer.write(jsonData);
        }
    }

    private Person deserializeFromJson() throws IOException {
        Gson gson = new Gson();
        StringBuilder jsonData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }

        return gson.fromJson(jsonData.toString(), Person.class);
    }

    @Test
    public void testSerializationAndDeserialization() throws IOException {
        createJsonFile();

        Person person = new Person("Pooji", "Bangalore", "247964082469");

        serializeToJson(person);

        Person deserializedPerson = deserializeFromJson();

        assertEquals(person.name, deserializedPerson.name);
        assertEquals(person.address, deserializedPerson.address);
        assertEquals(person.phnNum, deserializedPerson.phnNum);

        System.out.println("Serialization and Deserialization successful.");
        System.out.println("Deserialized Data: " + deserializedPerson.name + " , " + deserializedPerson.address + " , " + deserializedPerson.phnNum);
    }
}