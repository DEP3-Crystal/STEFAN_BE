package crystal.random_person_program.dao;

import com.opencsv.CSVWriter;
import crystal.random_person_program.Students;
import crystal.random_person_program.model.Person;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentsFromMemory extends Students {

    public static ArrayList<String> FIRST_CLASS_EMAILS = new ArrayList<>(Arrays.asList("danjel.halili@crystal-system.eu", "flavio.lorenci@crystal-system.eu", "elia.omeri@crystal-system.eu", "ardit.elezi@crystal-system.eu",
            "luka.buziu@crystal-system.eu", "megi.lala@crystal-system.eu",
            "irena.shahini@crystal-system.eu", "indrit.vaka@crystal-system.eu",
            "griselda.muci@crystal-system.eu", "theodor.gheorghe@crystal-system.eu",
            "ioan.cocianu@crystal-system.eu", "teofil.mitrea@crystal-system.eu",
            "eduard.tiutiu@crystal-system.eu", "george.dobrota@crystal-system.eu",
            "stefanita.plesa@crystal-system.eu", "adrian-nicolae.tigau@crystal-system.eu",
            "emanuel.grabovschi@crystal-system.eu", "george.sirbu@crystal-system.eu",
            "andrei.state@crystal-system.eu", "florin-adrian.dumitru@crystal-system.eu",
            "victor.hincu@crystal-system.eu", "stefan.ruci@crystal-system.eu"));

    public StudentsFromMemory() {
        setStudentsFromAEmailList();
    }

    public void setStudentsFromAEmailList() throws NullPointerException {
        FIRST_CLASS_EMAILS.forEach(student -> getPeople().add(new Person(student)));
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
}




