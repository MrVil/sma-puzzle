package com.guylplatteau.sma.puzzle.model;

import java.awt.Point;
import java.util.List;


public class Agent extends Thread {

    private static final int GRID_WIDTH = 5, GRID_HEIGHT = 5;
    private static Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT);

    private Point currentPosition, destination;
    private List<Agent> neighbors;

    Agent(Point position, Point destination) {
        this.currentPosition = position;
        this.destination = destination;
        grid.add(this);
        //neighbors = grid.getNeighbors(this);
    }

    Agent(int x, int y, int destination_x, int destination_y){
        this(new Point(x,y), new Point(destination_x, destination_y));
    }

    public Point getPosition() {
        return currentPosition;
    }

    public int getX()
    {
        return currentPosition.x;
    }

    public int getY()
    {
        return currentPosition.y;
    }

}