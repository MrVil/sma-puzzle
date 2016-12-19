package com.guylplatteau.sma.puzzle.model;

import java.util.ArrayList;

/**
 * Created by jonat on 19/12/2016.
 */
public class MessageManager {
    private ArrayList<Message> messages;

    MessageManager() {
        messages = new ArrayList<>();
    }

    public ArrayList<Message> getMessages(Agent agent) {
        ArrayList<Message> result = new ArrayList<>();
        for (Message message: messages) {
            if(message.getReceiver().equals(agent)) {
                result.add(message);
                messages.remove(message);
            }
        }
        return result;
    }

    public void send(Agent james, Agent )
}
