
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int answer = 1, rIndex;
        List<String> chosen = new ArrayList<>();
        List<String> classNames = new ArrayList<>(Arrays.asList(
                "danjel.halili@crystal-system.eu", "flavio.lorenci@crystal-system.eu",
                "elia.omeri@crystal-system.eu", "ardit.elezi@crystal-system.eu",
                "luka.buziu@crystal-system.eu", "megi.lala@crystal-system.eu",
                "irena.shahini@crystal-system.eu", "indrit.vaka@crystal-system.eu",
                "griselda.muci@crystal-system.eu", "theodor.gheorghe@crystal-system.eu",
                "ioan.cocianu@crystal-system.eu", "teofil.mitrea@crystal-system.eu",
                "eduard.tiutiu@crystal-system.eu", "george.dobrota@crystal-system.eu",
                "stefanita.plesa@crystal-system.eu", "adrian-nicolae.tigau@crystal-system.eu",
                "emanuel.grabovschi@crystal-system.eu", "george.sirbu@crystal-system.eu",
                "andrei.state@crystal-system.eu", "florin-adrian.dumitru@crystal-system.eu",
                "victor.hincu@crystal-system.eu", "stefan.ruci@crystal-system.eu"));

        Random rand = new Random();
        Scanner input = new Scanner(System.in);


        System.out.println("PROGRAM TO CHOSE RANDOMLY A STUDENT \n PRESS :\n 1-> CHOSE A STUDENT \n 2->SHOW ALL STUDENTS " +
                "\n 3->SHOW ALL STUDENT CHOSEN \n 0-> GET OUT OF  THE PROGRAM");
        answer = input.nextInt();
        while (answer != 0) {
            if (classNames.size() != 0) {
                switch (answer){
                    case 1:
                        rIndex = rand.nextInt(classNames.size());

                        System.out.println("The previously selected : " + chosen + "\n");
                        System.out.println("Choosen Classmates: " + classNames.get(rIndex));
                        chosen.add(classNames.get(rIndex));
                        classNames.remove(rIndex);
                        break;
                    case 2:
                        System.out.println("All Students :  " + classNames + "\n");

                        break;
                    case 3:
                        System.out.println("The previously selected : " + chosen + "\n");
                    default:
                        System.out.println("You must chose one of the options {0,1,2,3}");
                }
                System.out.println(" PRESS :\n 1-> CHOSE OTHER STUDENT \n 2->SHOW ALL STUDENTS \n" +
                        " 3->SHOW ALL STUDENT CHOSEN \n 0-> GET OUT OF  THE PROGRAM");
                answer = input.nextInt();
            } else {
                // classNames = (List<String>) ((ArrayList<String>) chosen).clone();
                classNames.addAll(chosen);
                chosen.clear();
                System.out.println("FINISH LIST ,STARTING FROM BEGINNING");

            }
        }
    }
}