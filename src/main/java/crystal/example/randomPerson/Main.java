package crystal.example.randomPerson;

import crystal.example.randomPerson.controller.GameControlFlow;
import crystal.example.randomPerson.model.Students;

import java.io.IOException;
import java.util.*;

public class Main {
    // Todo: create model  package and there define a Student model
    //define a ControllerClass
    //define a MenuClass OutputManager
    //define a  Class "Validator"
    // create dao package and there define a class for IO operation
    //  -define a getDataFromMemory,getDataFromFile,SaveData
    //

    public static void main(String[] args) throws IOException {
        Students students=new Students();
        GameControlFlow gameControlFlow=new GameControlFlow();
        gameControlFlow.startRandomChoosingProgram(students);
    }
}