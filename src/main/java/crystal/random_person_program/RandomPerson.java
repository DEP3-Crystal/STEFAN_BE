package crystal.random_person_program;

import crystal.random_person_program.model.Person;

import java.io.IOException;
import java.util.*;

public abstract class RandomPerson {

    private  List<Person> people = new ArrayList<>();
    private ArrayList<Person> chosenPeople = new ArrayList<>();


    public ArrayList<Person> getChosenStudents() {
        return this.chosenPeople;
    }
    public List<Person> getPeople() {
        return this.people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int chooseAPerson(List <Person> list) {
        Random random = new Random();
        int rindex = random.nextInt(list.size());
        list.get(rindex).setChosenTimes(list.get(rindex).getChosenTimes() + 1);
        return rindex;
    }

    public void deleteAMemberByMail(String email) {
        if (arrayContainsEmail(email)) {
            people.removeIf(person -> Objects.equals(email, person.getEmail()));
            System.out.println("Student Deleted ");
        } else System.out.println("This person doesn't exist or your input is incorrect :");

    }


    public void addAMemberByEmail( String email) {
        if (!arrayContainsEmail(email)) {
            this.people.add(new Person(email));
        } else {
            System.out.println("This person already exist :");
        }

    }

    private boolean arrayContainsEmail(String email) {
        return this.people.stream().map(Person::getEmail).toList().contains(email);
    }

    void chose() {
        int chosenIndex;
        chosenIndex = chooseAPerson(this.people);
        getChosenStudents().add(people.get(chosenIndex));
        System.out.println("chosen Student : " + this.people.get(chosenIndex).getFullName() + "\n");
        this.people.remove(chosenIndex);
    }

    void showChosenStudents() {
        getChosenStudents().forEach(System.out::println);


    }

    void listAllPersons() {
        this.people.forEach(System.out::println);
        showChosenStudents();
    }

    public void chosensValidation( ) {
        if (this.people.isEmpty()) {
            this.people.addAll(getChosenStudents());
            getChosenStudents().clear();
        }
    }

//    public static void main(String[] args) throws IOException {
//        RandomPerson person =new StudentsFromMemory();
//        Set<Person> a = new HashSet<>();
//        System.out.println(person.people.stream().map(Person::getEmail).collect(Collectors.toSet()));
//        List<String> p = person.people.stream().map(Person::getEmail).toList();
//        System.out.println(p.contains(p.get(0)));
//        System.out.println(p.get(0).equals("danjel.halili@crystal-system.eu"));
//        System.out.println(person.people.stream().map(Person::getEmail).collect(Collectors.toSet()).contains("stefan.ruci@crystal-system.eu"));
//    }
    public abstract   void startForStudents() throws IOException;

}
