package com.guylplatteau.sma.puzzle.view;

import com.guylplatteau.sma.puzzle.model.Grid;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jonat on 12/12/2016.
 */
public class GridView implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Grid grid = (Grid) o;
        for(byte j = 0; j < grid.getHeight(); ++j){
            for(byte i = 0; i < grid.getWidth(); ++i)
            {
                if(grid.getPosition(i,j) == null)
                    System.out.println(" ");
                else
                    System.out.println("X");
            }
            System.out.println();
        }

    }
}
