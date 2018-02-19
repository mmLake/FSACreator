package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayalake on 2/17/18.
 */
public class ReadInput {

    public final String INPUT_FILE_PATH = "src/input.txt";
    BufferedReader bufferreader;

    public ReadInput(){
        try {
            bufferreader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public NFSA getNextFsa(){
        try{
            NFSA NFSA = new NFSA();
            String acceptedString;
            int stateCount = 1;
            ArrayList<State> allStates = new ArrayList<>();

            while (!(acceptedString = bufferreader.readLine()).startsWith("(")){
                for (int i = 0; i < acceptedString.length(); i++) {
                    char curC = acceptedString.charAt(i);

                    //add to alphabet
                    NFSA.modifyAlphabet(curC);

                    //add transition
                    State state = new State(stateCount, curC);

                    if (i == acceptedString.length() - 1) {
                        state.setFinalState(true);
                    }

                    int prevState = (i == 0? 0 : stateCount - 1);
                    NFSA.addStateToNFSA(state, prevState);

                    stateCount++;
                }
            }

            //read in test strings
            String testStrs = acceptedString.substring(1, acceptedString.length()-1);
            NFSA.setTestStrings(testStrs.split(" "));

            return NFSA;
        } catch (Exception ex) {
            return null;
        }

    }

}
