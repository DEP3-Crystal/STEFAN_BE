package crystal.example.randomPersonProgram.model;


import lombok.Data;

import java.util.List;
@Data
public class Person {
    private String name;
    private String fullName;
    private String lastname;
    private String email;
    private int chosenTimes;

    public Person(String email) {
        setEmail(email);
        setFullName();
        setLastname();
        setName();
        setChosenTimes(0);
    }


    public String getName() {
        return name;
    }

    public void setName() {
        this.name = "";
        List<String> list = new java.util.ArrayList<>(List.of(this.fullName.split(" ")));
        list.remove(list.size() - 1);
        list.forEach(e -> {
            this.name += e + " ";
        });
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname() {
        String[] res = this.fullName.split(" ");
        this.lastname = res[res.length - 1];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChosenTimes() {
        return chosenTimes;
    }

    public void setChosenTimes(int chosenTimes) {
        this.chosenTimes = chosenTimes;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName() {
        this.fullName = this.email.replaceAll("((@.*)|[^a-zA-Z])+", " ").trim();
        this.fullName = this.fullName.substring(0, 1).toUpperCase() + this.fullName.substring(1);
        for (int i = 0; i < this.fullName.length(); i++) {
            if (' ' == this.fullName.charAt(i)) {
                this.fullName = this.fullName.substring(0, i + 1) + this.fullName.substring(i + 1, i + 2).toUpperCase() + this.fullName.substring(i + 2);
            }

        }

    }

    @Override
    public String toString() {
        return "Name : " + name + ",\t" +
                "FullName : " + fullName + ",\t" +
                "Lastname : " + lastname + ",\t" +
                "Email : " + email + ",\t" +
                "ChosenTimes : " + chosenTimes;
    }


}
