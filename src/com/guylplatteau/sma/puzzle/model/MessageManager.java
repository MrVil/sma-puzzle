package com.guylplatteau.sma.puzzle.model;

import java.util.ArrayList;

/**
 * Created by jonat on 19/12/2016.
 */
class MessageManager {
    private ArrayList<Message> messages;

    MessageManager() {
        messages = new ArrayList<>();
    }

    synchronized ArrayList<Message> getMessages(Agent agent) {
        ArrayList<Message> result = new ArrayList<>();
        for (Message message: messages) {
            if(message.getReceiver().equals(agent)) {
                result.add(message);
            }
        }
        for (Message message: result)
        {
            messages.remove(message);
        }
        return result;
    }

    synchronized void send(Message m) {
        messages.add(m);
    }
}
