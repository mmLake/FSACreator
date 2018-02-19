package com.maya;

import Model.NFSA;
import Model.ReadInput;
import Model.WriteOutput;

public class Main {

    public static void main(String[] args) {
        ReadInput input = new ReadInput();
        NFSA fsa;
        WriteOutput output = new WriteOutput();

        while ((fsa  = input.getNextFsa()) != null){
            output.appendToFile(fsa);
        }
    }
}
