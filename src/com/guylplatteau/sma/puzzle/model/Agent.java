package com.guylplatteau.sma.puzzle.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Thread {

    private static final int GRID_WIDTH = 5, GRID_HEIGHT = 5;
    private static Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT);
    private static ArrayList<Message> messages = new ArrayList<>();

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

    private Point getNextMove(){
        double minDist = Integer.MAX_VALUE;
        Point nextMove = new Point(currentPosition);
        for(byte i = -1 ; i < 2; i++)
            for(byte j = -1; j < 2; j++){
                double dist = destination.distance(currentPosition.x + i, currentPosition.y + j);
                if(dist < minDist){
                    minDist = dist;
                    nextMove = new Point(currentPosition.x + i, currentPosition.y +j);
                }
            }
        return nextMove;
    }

    private void updatePosition()
    {
        Point goal = getNextMove();
        if(grid.requestPosition(this, goal))
            currentPosition = goal;
        else
            MessageManager.send(new Message(this,grid.getPosition(goal), Perform.REQUEST, Action.FREE));
    }

    @Override
    public void run(){
        while (running){
            updatePosition();

            if(currentPosition.equals(destination))
                running = false;
        }
    }

    public void messageHandler(Message message){
        switch (message.getAction()){
            case FREE: onFree(); break;
        }

    }

    private void onFree() {

    }

}