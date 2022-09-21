package crystal.random_person_program;

import crystal.random_person_program.controller.RandomProgram;

import java.io.IOException;

public class Main {
    // Todo: create model  package and there define a Student model
    //define a ControllerClass
    //define a MenuClass OutputManager
    //define a  Class "Validator"
    // create dao package and there define a class for IO operation
    //  -define a getDataFromMemory,getDataFromFile,SaveData
    public static void main(String[] args) throws IOException {
        RandomProgram program=new RandomProgram();
        program.start();
    }
}