package crystal.example.randomPerson.model;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Student> chosenStudents = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }


    public void setStudentsFromAEmailList(String[] classEmails) throws NullPointerException {

        for (String classEmail : classEmails) {
            this.students.add(new Student(classEmail));
        }


    }

    public void setStudentsFromAFile(String path) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            this.students.add(new Student(scanner.nextLine()));
        }

    }

    public void writeAllLines(String[] lines, String path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(path)))) {
            for (String line : lines) {
                try {
                    String[] a = {line};
                    writer.writeNext(a);
                } catch (NullPointerException ignored) {
                }
            }
        }
    }

    public ArrayList<Student> getChosenStudents() {
        return chosenStudents;
    }

    public void setChosenStudents(ArrayList<Student> chosenStudents) {
        this.chosenStudents = chosenStudents;
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
