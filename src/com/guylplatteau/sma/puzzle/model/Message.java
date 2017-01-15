package com.guylplatteau.sma.puzzle.model;

/**
 * Created by jonat on 19/12/2016.
 */
public class Message {
    private Agent emmiter;
    private Agent receiver;
    private Perform perform;
    private Action action;

    Message(Agent emmiter, Agent receiver, Perform p, Action a) {
        this.emmiter = emmiter;
        this.receiver = receiver;
        this.perform = p;
        this.action = a;
    }

    Agent getReceiver() {
        return receiver;
    }

    public Perform getPerform() {
        return perform;
    }

    Action getAction() {
        return action;
    }

    public Agent getEmmiter() {
        return emmiter;
    }
}

enum Perform {
    REQUEST,
    RESPONSE
}
enum Action {
    FREE,
    MOVE,
    GTFO,
    OK
}