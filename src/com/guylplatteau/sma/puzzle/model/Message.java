package com.guylplatteau.sma.puzzle.model;

import com.sun.istack.internal.NotNull;

/**
 * Created by jonat on 19/12/2016.
 */
public class Message {
    private Agent emitter;
    private Agent receiver;
    private Perform perform;
    private Action action;

    Message(Agent emitter, @NotNull Agent receiver, Perform p, Action a) {
        this.emitter = emitter;
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

    public Agent getEmitter() {
        return emitter;
    }
}

enum Perform {
    REQUEST,
    RESPONSE
}
enum Action {
    FREE,
    OK
}