package Model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by mayalake on 2/17/18.
 */
public class NFSA {
    private State initialState;
    private HashSet<Character> alphabet = new HashSet<Character>();
    private String[] testStrings;
    private int totalStateSize;

    public NFSA(){
        initialState = new State(0, null);
        totalStateSize = 1;
    }

    public void addStateToNFSA(State state, int prevStateIdx){
        State prevState = (prevStateIdx == 0? initialState : returnStateWithIndex(prevStateIdx));
        prevState.modifyNextStates(state);

        totalStateSize++;
    }

    private State returnStateWithIndex(int index){

        for (State statesFromRoot : initialState.getNextStates()){
            State tempState = statesFromRoot;

            if (tempState.getStateIndex() == index){
                return tempState;
            }

            while(tempState.getNextStates().size() != 0){
                tempState = tempState.getNextStates().get(0);

                if (tempState.getStateIndex() == index){
                    return tempState;
                }
            }

        }
        return null;
    }

    public boolean acceptString(String testStr){
        Boolean accepted = false;
        State curState = initialState;
        char initialSymbol = testStr.charAt(0);

        //find states consumed by initial state
        for (int i = 0; i < initialState.getNextStates().size(); i++){
            curState = initialState.getNextStates().get(i);

            //find the
            if (curState.getSymbolConsumed() == initialSymbol){
                for (char c : testStr.toCharArray()){
                    if (curState.getSymbolConsumed() == c){
                        curState = curState.getNextStates().get(0);
                        accepted = true;
                    } else {
                        accepted = false;
                    }
                }
            }
        }

        //check if state is final state
        return (accepted && curState.isFinalState());
    }

    public ArrayList<Integer> getFinalStates(){
        ArrayList<Integer> finalStates = new ArrayList<Integer>();

        for (int i = 1; i < totalStateSize; i++){
            if (returnStateWithIndex(i).isFinalState()){
                finalStates.add(i);
            }
        }
        return finalStates;
    }

    public ArrayList<String> transitions(){
        //add all transitions from initial state
        ArrayList<String> transitions = new ArrayList<String>();

        for (int i = 1; i < totalStateSize; i++){
            State curState = returnStateWithIndex(i);
            State transState = returnStateWithIndex(i).getNextStates().get(0);
            transitions.add("" + curState.getStateIndex() +  transState.getSymbolConsumed() + transState.getStateIndex());
        }

        return null;
    }

    public void modifyAlphabet(Character character) {
        this.alphabet.add(character);
    }

    public ArrayList<Character> getAlphabet() {
        return new ArrayList<Character>(alphabet);
    }

    public String[] getTestStrings() {
        return testStrings;
    }

    public void setTestStrings(String[] testStrings) {
        this.testStrings = testStrings;
    }

    public int getTotalStateSize() {
        return totalStateSize;
    }

}
