package crystal.random_person_program.dao;

import crystal.random_person_program.model.Person;
import crystal.random_person_program.Students;

import java.io.*;
import java.util.Scanner;

public class StudentsFromFile extends Students {
    public StudentsFromFile() throws IOException {
        playFromFile();
    }

    public void playFromFile() throws IOException {
        Scanner input = new Scanner(System.in);
        int answer;
        System.out.println("PRESS 1 TO ENTER A FILE PATH OR CONTINUE WITH YOUR DEFAULT FILE");
        answer = input.nextInt();
        String defFilePath = "C:/Users/HP/IdeaProjects/RandomPersonSR/src/main/resources/classEmails.csv";
        if (answer == 1) {
            System.out.println("Enter file path : ");
            defFilePath = input.next();
        }
      setStudentsFromAFile(defFilePath);
    }
    public void setStudentsFromAFile(String path) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
          getPeople().add(new Person(scanner.nextLine()));
        }
    }

}
