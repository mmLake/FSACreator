package Model;

import java.io.*;
import java.util.Arrays;

public class WriteOutput {

    public static final String OUTPUT_FILE_PATH = "output.txt";

    public void appendToFile(NFSA fsa){

        try (FileWriter fileWriter = new FileWriter(OUTPUT_FILE_PATH, true)){
            BufferedWriter bufferwriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferwriter);

            printWriter.println("Finite State Automaton:");

            //print number of states, final states, alphabet
            printWriter.printf("(1)number of states: %d%n" +
                            "(2)final states: %s%n" +
                            "(3)alphabet: %s%n",
                            fsa.getTotalStateSize(),
                            Arrays.toString(fsa.getFinalStates().toArray()), Arrays.toString(fsa.getAlphabet().toArray()));

            //print 2d array table
//            printWriter.println("(4)transitions:");
//            for (int row = 0; row < fsa.getFsaTable().length; row ++){
//                for (int col = 0; col < fsa.getFsaTable()[0].length; col++){
//                    printWriter.printf("%5d%5d%5d%n", row, col, fsa.getFsaTable()[row][col]);
//                }
//            }

            //print test strings
//            printWriter.println("(5)strings:");
//            for (String testStr : fsa.getTestStrings()){
//                printWriter.printf("%-15s\t%-10s%n", testStr, fsa.acceptTestString(testStr));
//            }
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeOutputFile(){

    }
}
