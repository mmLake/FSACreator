package Model;

import java.util.ArrayList;

/**
 * Created by mayalake on 2/17/18.
 */
public class State {
    private ArrayList<State> nextStates = new ArrayList<>();
    private State prevState;
    private Character symbolConsumed;
    private int stateIndex;
    private boolean isFinalState = false;

    public State(int stateIndex, Character symbolConsumed){
        this.stateIndex = stateIndex;
        this.symbolConsumed = symbolConsumed;
    }

    public ArrayList<State> getNextStates() {
        return nextStates;
    }

    public void modifyNextStates(State state) {
        nextStates.add(state);
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    public void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }

    public char getSymbolConsumed() {
        return symbolConsumed;
    }

    public int getStateIndex() {
        return stateIndex;
    }



}
