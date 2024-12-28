package org.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {


    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("test-system");

        ActorRef readingActorRef
                = system.actorOf(Props.create(MyActor.class), "my-actor");

        ActorRef readingActorRef1 = system.actorOf(
                ReadingActor.props("text"), "readingActor");



    }

}
