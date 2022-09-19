package crystal.example.randomPerson.controller;

import crystal.example.randomPerson.dao.StudentsEmails;
import crystal.example.randomPerson.model.Student;
import crystal.example.randomPerson.model.Students;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class GameControlFlow {

    public void startRandomChoosingProgram(Students students) throws IOException {
        fistGameMenu();
        int answer = input.nextInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    students.setStudentsFromAEmailList(StudentsEmails.FIRST_CLASS_EMAILS);

                    playGame(students, answer);
                    break;
                case 2:
                    System.out.println("PRESS 1 TO ENTER A FILE PATH OR CONTINUE WITH YOUR DEFAULT FILE");
                    answer = input.nextInt();
                    String defFilePath = "C:/Users/HP/IdeaProjects/RandomPersonSR/src/main/resources/classEmails.csv";
                    if (answer == 1) {
                        System.out.println("Enter file path : ");
                        defFilePath = input.nextLine();
                    }
                    students.setStudentsFromAFile(defFilePath);

                    playGame(students, answer);

                    break;
                default:
                    System.out.println("You must chose one of the options {0,1,2}");
                    fistGameMenu();
                    answer = input.nextInt();
                    break;


            }
        }
    }

    public int chooseAPerson(ArrayList<Student> list) {
        Random random = new Random();
        int rindex = random.nextInt(list.size());
        list.get(rindex).setChosenTimes(list.get(rindex).getChosenTimes() + 1);
        return rindex;
    }

    public void fistGameMenu() {
        System.out.println("""
                PROGRAM TO CHOSE RANDOMLY A STUDENT\s
                 FROM WHERE YOU WANT TO ADD STUDENTS ?
                 PRESS :
                 1->ADD FROM YOUR LIST OF EMAILS\s
                 2->ADD FROM YOUR FILE OF  EMAILS LIST
                 0->GET OUT OF  THE PROGRAM""");
    }

    public void randomGameMenuInput() {
        System.out.println("\n PRESS :" +
                "\n 1 -> CHOSE A STUDENT " +
                "\n 2 -> SHOW ALL STUDENTS " +
                "\n 3 -> SHOW ALL STUDENT CHOSEN  " +
                "\n 4 -> ADD A STUDENT " +
                "\n 5 -> DELETE A STUDENT FROM ." +
                "\n 0 -> GET OUT OF  THE PROGRAM");

    }

    public void deleteAMemberByFullName(Students students, String fullName) {
        if (!students.getStudents().contains(fullName)) {
            students.getStudents().removeIf(student -> Objects.equals(student.getFullName(), fullName));

        } else System.out.println("This student doesn't exist or your input is incorrect :");

    }

    public void addAMemberByEmail(Students students, String email) {
        if (students.getStudents().contains(email)) {
            students.getStudents().add(new Student(email));
        } else {
            System.out.println("This student already exist :");
        }

    }

    public void playGame(Students students, int answer) {
        int chosenIndex;
        do {
            randomGameMenuInput();
            answer = input.nextInt();
            switch (answer) {
                case 1:
                    chosenIndex = chooseAPerson(students.getStudents());
                    students.getChosenStudents().add(students.getStudents().get(chosenIndex));
                    System.out.println("chosen Student : " + students.getStudents().get(chosenIndex).getFullName() + "\n");
                    students.getStudents().remove(chosenIndex);
                    break;
                case 2:
                    System.out.println("SHOWING ALL STUDENTS : \n");
                    students.getStudents().forEach(System.out::println);
                    students.getChosenStudents().forEach(System.out::println);
                    break;
                case 3:
                    if (!students.getChosenStudents().isEmpty()) {
                        System.out.println("CHOSEN STUDENTS :\n");
                        students.getChosenStudents().forEach(System.out::println);
                    }
                    break;
                case 4:
                    String email1;
                    System.out.println("enter email  of the student you want to delete : ");
                    email1 = input.next();
                    addAMemberByEmail(students, email1);
                    break;
                case 5:
                    //"\n 5 -> DELETE A STUDENT FROM " + input + "." +
                    String fullname;
                    System.out.println("enter full name of the student you want to delete : ");
                    fullname = input.nextLine();
                    deleteAMemberByFullName(students, fullname);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You must chose one of the options {0,1,2,3,4,5}");
                    answer = 6;
            }
            chosensValidation(students);

        } while (answer != 0);

    }

    public void chosensValidation(Students students) {
        if (students.getStudents().isEmpty()) {
            students.getStudents().addAll(students.getChosenStudents());
            students.getChosenStudents().clear();
        }
    }

    Scanner input = new Scanner(System.in);
}
