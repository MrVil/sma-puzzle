package com.guylplatteau.sma.puzzle.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Grid extends Observable {

    private int width, height;
    private Agent[][] grid;
    private boolean finished = false;

    Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        grid = new Agent[width][height];
    }

    synchronized boolean requestPosition(Agent agent, Point desired)
    {
        if(desired.x >= 0 && desired.x < width &&
                desired.y >= 0 && desired.y < height &&
                grid[desired.x][desired.y] == null)
        {
            grid[agent.getX()][agent.getY()] = null;
            grid[desired.x][desired.y] = agent;
            this.setChanged();

            notifyObservers();
            return true;
        }
        if(desired.x < 0){
            System.out.println("Out of range - x negative");
        }
        if(desired.y < 0){
            System.out.println("Out of range - y negative");
        }
        if(desired.x >= width){
            System.out.println("Out of range - x >= width");
        }
        if(desired.y >= height){
            System.out.println("Out of range - x >= height");
        }
        //System.out.println("Desired {"+desired.x+","+desired.y+"}, agent("+agent.getPosition().x+","+agent.getPosition().y+")");
        return false;
    }

    void add(Agent agent)
    {
        requestPosition(agent, agent.getPosition());
    }

    Agent getPosition(Point position)
    {
        return getPosition(position.x, position.y);
    }

    public Agent getPosition(int x, int y)
    {
        return grid[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    synchronized public boolean isFinished() {
        if(finished)
            return true;

        finished = true;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if(grid[i][j] != null){
                    if(grid[i][j].getPosition().equals(grid[i][j].getDestination())){
                        //System.out.println("{"+i+","+j+"}-"+grid[i][j].display);
                    }
                    finished = finished && grid[i][j].getPosition().equals(grid[i][j].getDestination());
                }
            }
        }
        return finished;
    }

}
