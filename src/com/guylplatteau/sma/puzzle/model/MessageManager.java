package com.guylplatteau.sma.puzzle.model;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created by jonat on 19/12/2016.
 */
class MessageManager {
    private ArrayList<Message> messages;

    MessageManager() {
        messages = new ArrayList<>();
    }

    synchronized ArrayList<Message> getMessages(@NotNull Agent agent) {
        ArrayList<Message> result = new ArrayList<>();

        if(messages.isEmpty() || messages == null)
            return new ArrayList<>();

        for (Message message: messages) {
            try{
                if(message.getReceiver().equals(agent) && !message.getEmitter().equals(agent)) {
                    result.add(message);
                }
            }
            catch(Exception e){

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
