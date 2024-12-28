package org.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ReadingActor extends AbstractActor {
    private String text;

    public static Props props(String text) {
        return Props.create(ReadingActor.class, text);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().build();
    }
}
