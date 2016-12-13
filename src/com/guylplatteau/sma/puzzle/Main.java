package com.guylplatteau.sma.puzzle;

import com.guylplatteau.sma.puzzle.model.Agent;
import com.guylplatteau.sma.puzzle.view.GridView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<>();

        GridView gw = new GridView();
        Agent.getGrid().addObserver(gw);

        for(int i = 0; i < 5; i++){
            Agent a = new Agent(0,i,1,i);
            agents.add(a);
            a.start();
        }

    }
}
