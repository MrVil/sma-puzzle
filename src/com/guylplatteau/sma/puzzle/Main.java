package com.guylplatteau.sma.puzzle;

import com.guylplatteau.sma.puzzle.model.Agent;
import com.guylplatteau.sma.puzzle.view.GridView;
import com.guylplatteau.sma.puzzle.view.Puzzle;
import com.guylplatteau.sma.puzzle.view.PuzzleEx;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<>();

        GridView gw = new GridView();
        Agent.getGrid().addObserver(gw);

        /*Agent a = new Agent(0,0,3,0);
        agents.add(a);*/

        ArrayList<Point> positionsAvailable = new ArrayList<>();
        ArrayList<Agent> agentsAvailable = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j ++){
                positionsAvailable.add(new Point(i, j));
                agentsAvailable.add(new Agent(i,j, i, j, (char) (64 + (i+1)+(j*5)) ));
            }
        }

        Collections.shuffle(positionsAvailable);
        Collections.shuffle(agentsAvailable);

        for(int i = 0; i < 20; i++){
            Agent tmp = agentsAvailable.remove(0);
            tmp.setPosition(positionsAvailable.remove(0));
            agents.add(tmp);
        }



        /*for(int i = 0; i < 5; i++){
            Agent a = new Agent(0,i,3,i, Character.forDigit(i, 10));
            agents.add(a);
        }

        for(int i = 0; i < 5; i++){
            Agent a = new Agent(1,i,4,i, Character.forDigit(i+5, 10));
            agents.add(a);
        }*/

        /*Agent a1 = new Agent(0,0,3, 3);
        Agent a2 = new Agent(3,3,0, 0);
        agents.add(a1);
        agents.add(a2);*/

        for(Agent agent : agents){
            agent.start();
        }
        /*
        EventQueue.invokeLater(() -> {
            PuzzleEx puzzle = new PuzzleEx();
            puzzle.setVisible(true);
        });

        Puzzle.main(new String[0]);*/


    }
}
