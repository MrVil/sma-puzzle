package com.guylplatteau.sma.puzzle.model;

import java.awt.Point;
import java.util.List;


public class Agent extends Thread {

    private static final int GRID_WIDTH = 5, GRID_HEIGHT = 5;
    private static Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT);

    private Point currentPosition, destination;
    private List<Agent> neighbors;
    private boolean running = true;

    private Agent(Point position, Point destination) {
        this.currentPosition = position;
        this.destination = destination;

        grid.add(this);
        //neighbors = grid.getNeighbors(this);
    }

    public Agent(int x, int y, int destination_x, int destination_y){
        this(new Point(x,y), new Point(destination_x, destination_y));
    }

    public static Grid getGrid() {
        return grid;
    }

    Point getPosition() {
        return currentPosition;
    }

    int getX()
    {
        return currentPosition.x;
    }

    int getY()
    {
        return currentPosition.y;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Point getDestination() {
        return destination;
    }

    @Override
    public void run(){
        while (running){
            if(grid.updatePosition(this, destination))
                currentPosition = destination;

            if(currentPosition.equals(destination))
                running = false;
        }
    }

}