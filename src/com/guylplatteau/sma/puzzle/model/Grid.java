package com.guylplatteau.sma.puzzle.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Grid extends Observable {

    int width, height;
    Agent[][] grid;

    Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        grid = new Agent[width][height];
    }

    public synchronized boolean requestPosition(Agent agent, Point desired)
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
        return false;
    }

    void add(Agent agent)
    {
        requestPosition(agent, agent.getPosition());
    }

    public Agent getPosition(Point position)
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
}
