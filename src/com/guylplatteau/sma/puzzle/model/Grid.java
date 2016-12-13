package com.guylplatteau.sma.puzzle.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

class Grid extends Observable {

    int width, height;
    Agent[][] grid;

    Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        grid = new Agent[width][height];
    }

    private boolean updatePosition(Agent agent, Point desired)
    {
        if(desired.x > 0 && desired.x < width &&
                desired.y > 0 && desired.y < height &&
                grid[desired.x][desired.y] == null)
        {
            grid[agent.getX()][agent.getY()] = null;
            grid[desired.x][desired.y] = agent;
            notifyObservers();
            return true;
        }
        return false;
    }

    void add(Agent agent)
    {
        updatePosition(agent, agent.getPosition());
    }
}
