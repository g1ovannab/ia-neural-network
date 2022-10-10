import java.io.*;
import java.util.*;


import java.io.FileNotFoundException;

public class App {
    public int DATA = 284;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //read csv file treinamento de algarismos

        //cada linha é um algarismo
        //cada primeiro número da linha é O algarismo

        String path = App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "files/Treinamento de Algarismos.csv";

        NeuralNetwork neuralNetwork = new NeuralNetwork(path);
        
        neuralNetwork.Train();
    }
}
