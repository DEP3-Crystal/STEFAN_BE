package crystal.random_person_program.controller;

import crystal.random_person_program.RandomPerson;
import crystal.random_person_program.dao.StudentsFromFile;
import crystal.random_person_program.dao.StudentsFromMemory;

import java.io.IOException;
import java.util.Scanner;


public class RandomProgram {
    public RandomProgram() {
        System.out.println("PROGRAM TO CHOSE RANDOMLY A PERSON\n");
    }

    public void start() throws IOException {
        choseDataSource();
    }

    public void stop() {
        System.exit(0);
    }

    public void choseDataSource() throws IOException {
        RandomPerson person;
        choseSourceMenu();
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    person = new StudentsFromMemory();
                    person.startForStudents();
                    break;
                case 2:
                    person = new StudentsFromFile();
                    person.startForStudents();
                    break;
                case 0:
                    System.out.println("bye!");
                    stop();
                    break;
                default:
                    System.out.println("You must chose one of the options {0,1,2}");
                    choseSourceMenu();
                    answer = input.nextInt();
                    break;
            }
        }
    }

    public static void choseSourceMenu() {
        System.out.println("""
                FROM WHERE YOU WANT TO ADD PERSONS ?
                PRESS :
                1->ADD FROM YOUR LIST OF EMAILS\s
                2->ADD FROM YOUR FILE OF  EMAILS LIST
                0->GET OUT OF  THE PROGRAM""");
    }

}
