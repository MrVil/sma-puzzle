package com.guylplatteau.sma.puzzle;

import com.guylplatteau.sma.puzzle.model.Agent;
import com.guylplatteau.sma.puzzle.view.GridView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<>();

        GridView gw = new GridView();
        Agent.getGrid().addObserver(gw);

        /*Agent a = new Agent(0,0,3,0);
        agents.add(a);
        a.start();*/

        /*for(int i = 1; i < 5; i++){
            Agent a = new Agent(0,i,3,i);
            agents.add(a);
            a.start();
        }*/
        Agent a1 = new Agent(0,0,3, 3);
        Agent a2 = new Agent(3,3,0, 0);

        agents.add(a1);
        agents.add(a2);

        for(int i = 0; i < 2; i++){
            agents.get(i).start();
        }


    }
}
