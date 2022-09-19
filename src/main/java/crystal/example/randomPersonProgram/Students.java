package crystal.example.randomPersonProgram;

import java.util.Scanner;

public abstract class  Students  extends  RandomPerson{
@Override
    public void startForStudents()  {
    Scanner input = new Scanner(System.in);
    int answer;
        do {
            MenuOfProgramChoises();
            answer = input.nextInt();
            switch (answer) {
                case 1:
                chose();
                    break;
                case 2:
                    System.out.println("SHOWING ALL STUDENTS : \n");
                    listAllPersons();
                    break;
                case 3:
                    if (!getChosenStudents().isEmpty()) {
                        System.out.println("CHOSEN STUDENTS :\n");
                        showChosenStudents();
                    }
                    break;
                case 4:
                    System.out.println("enter email  of the person you want to add : ");
                    addAMemberByEmail(input.next());
                    break;
                case 5:
                    System.out.println("Enter the email of the person you want to delete : ");
                    deleteAMemberByMail(input.next());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("You must chose one of the options {0,1,2,3,4,5}");
                    answer = 6;
            }
            chosensValidation();
        } while (answer !=0 );
    }


    public void MenuOfProgramChoises() {

        System.out.println("""
                PRESS :
                1 -> CHOSE A STUDENT\s
                2 -> SHOW ALL STUDENTS\s
                3 -> SHOW ALL STUDENT CHOSEN \s
                4 -> ADD A STUDENT\s
                5 -> DELETE A STUDENT FROM .
                0 -> GET OUT OF  THE PROGRAM""".indent(1));

    }
}
