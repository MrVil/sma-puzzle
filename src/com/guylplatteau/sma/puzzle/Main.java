package com.guylplatteau.sma.puzzle;

import com.guylplatteau.sma.puzzle.model.Agent;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Agent a = new Agent(0,0,0,0);
            agents.add(a);
            a.start();
        }

    }
}
