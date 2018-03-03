package com.guylplatteau.sma.puzzle.view;

import com.guylplatteau.sma.puzzle.model.Grid;

import java.util.Observable;
import java.util.Observer;

public class GridView implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Grid grid = (Grid) o;
        for(byte j = 0; j < grid.getHeight(); ++j){
            for(byte i = 0; i < grid.getWidth()*2 +2; ++i)
                System.out.print("-");
            System.out.println();

            System.out.print("|");
            for(byte i = 0; i < grid.getWidth(); ++i)
            {
                if(grid.getPosition(i,j) == null)
                    System.out.print(" ");
                else
                    System.out.print(grid.getPosition(i,j).display);

                System.out.print("|");

            }
            System.out.println();
        }
        for(byte i = 0; i < grid.getWidth()*2 +2; ++i)
            System.out.print("-");
        System.out.println();
        System.out.println();

    }
}
