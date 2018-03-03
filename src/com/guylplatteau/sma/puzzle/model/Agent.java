package com.guylplatteau.sma.puzzle.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Agent extends Thread {

    private static final int GRID_WIDTH = 5, GRID_HEIGHT = 5;
    private static Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT);
    private static MessageManager manager = new MessageManager();

    private Point currentPosition, destination;
    public boolean running = true;
    public char display;
    private boolean needToFree = false;

    private Agent(Point position, Point destination, char display) {
        this.currentPosition = position;
        this.destination = destination;
        this.display = display;
    }

    public Agent(int x, int y, int destination_x, int destination_y, char display){
        this(new Point(x,y), new Point(destination_x, destination_y), display);
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

    private Point getNextMove(){
        double minDist = Integer.MAX_VALUE;
        Point nextMove = new Point(currentPosition);
        for(byte i = -1 ; i < 2; i++){
            double dist = destination.distance(currentPosition.x + i, currentPosition.y);
            if(dist < minDist){
                minDist = dist;
                nextMove = new Point(currentPosition.x + i, currentPosition.y);
            }
        }

        for(byte j = -1; j < 2; j++){
            double dist = destination.distance(currentPosition.x, currentPosition.y + j);
            if(dist < minDist){
                minDist = dist;
                nextMove = new Point(currentPosition.x, currentPosition.y +j);
            }
        }

        return nextMove;
    }

    private void updatePosition()
    {
        Point goal = getNextMove();

        if(grid.requestPosition(this, goal))
            currentPosition = goal;
        else if(needToFree){
            if(currentPosition.x >= 1 && grid.requestPosition(this, new Point(currentPosition.x - 1, currentPosition.y))){
                currentPosition = new Point(currentPosition.x - 1, currentPosition.y);
                needToFree = false;
                //System.out.println("I get away");
            }
            else if(currentPosition.x < grid.getWidth()-1  && grid.requestPosition(this, new Point(currentPosition.x + 1, currentPosition.y))){
                currentPosition = new Point(currentPosition.x + 1, currentPosition.y);
                needToFree = false;
                //System.out.println("I get away");
            }
            else if(currentPosition.y >= 1 && grid.requestPosition(this, new Point(currentPosition.x, currentPosition.y - 1))){
                currentPosition = new Point(currentPosition.x, currentPosition.y - 1);
                needToFree = false;
                //System.out.println("I get away");
            }
            else if(currentPosition.y < grid.getHeight() -1 && grid.requestPosition(this, new Point(currentPosition.x, currentPosition.y + 1))){
                currentPosition = new Point(currentPosition.x, currentPosition.y + 1);
                needToFree = false;
                //System.out.println("I get away");
            }
            else{
                if(grid.getPosition(goal) == null){
                    //System.out.println("Fail A");
                }
                manager.send(new Message(this, grid.getPosition(goal), Perform.REQUEST, Action.FREE));
                //System.out.println("GET OUT THE WAY - Not for me");
            }
        }
        else{
            if(grid.getPosition(goal) == null){
                //System.out.println("Fail B");
            }
            manager.send(new Message(this,grid.getPosition(goal), Perform.REQUEST, Action.FREE));
        }

    }

    @Override
    public void run(){

        grid.add(this);

        while (running){
            ArrayList<Message> complains = manager.getMessages(this);
            if(complains != null && !complains.isEmpty()){
                for(Message m: complains){
                    messageHandler(m);
                }
            }
            updatePosition();

            if(grid.isFinished())
                running = false;
        }
    }

    public void messageHandler(Message message){
        switch (message.getAction()){
            case FREE: onFree(message); break;
        }

    }

    private void onFree(Message message) {
        //System.out.println("Agent["+message.getEmitter().currentPosition.x+","+message.getEmitter().currentPosition.y+"] veut ma place ("+currentPosition.x+","+currentPosition.y+")");
        needToFree = true;
    }

    public void setPosition(Point position) {
        this.currentPosition = position;
    }

    public Point getDestination() {
        return destination;
    }
}