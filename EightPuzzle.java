package org;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EightPuzzle {

    public static void main(String[] args) {

        File input = new File("/Users/rdey13/Documents/Homework/input/input1");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            String line;

            try {
                ArrayList<String> outputHeuristic1 = new ArrayList<>();
                ArrayList<String> outputHeuristic2 = new ArrayList<>();

                while ((line = bufferedReader.readLine()) != null){
                    String[] tokens = line.split(",");
                    int[] state = new int[9];
                    int i =0;
                    for (String current: tokens){
                        state[i] = Integer.parseInt(current);
                        i++;
                    }
                    Node node1 = new Node(state);
                    node1.expand();
                    outputHeuristic1.add(node1.displayOutFileHeuristic1());
                    outputHeuristic2.add(node1.displayOutFileHeuristic2());

                    System.out.println("Problem :");
                    System.out.println(node1.displayState(state));
                    node1.displayChildren();
                    System.out.println("\nHeuristics1(hDisplaced) :");
                    System.out.println(node1.displayOutFileHeuristic1());
                    System.out.println("\nHeuristics2(hManhattan) :");
                    System.out.println(node1.displayOutFileHeuristic2());

                }
                FileWriter fileWriter1 = new FileWriter("/Users/rdey13/Documents/Homework/output/OutFileHeuristic1.txt");
                for (int i =0; i<outputHeuristic1.size();i++){
                    fileWriter1.write(outputHeuristic1.get(i) + "\n");
                }
                fileWriter1.close();

                FileWriter fileWriter2 = new FileWriter("/Users/rdey13/Documents/Homework/output/OutFileHeuristic2.txt");
                for (int i =0; i<outputHeuristic2.size();i++){
                    fileWriter2.write(outputHeuristic2.get(i) + "\n");
                }
                fileWriter2.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
