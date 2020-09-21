package akka.first.app.java;

import akka.actor.*;
import akka.first.app.java.actors.MasterActor;
import akka.first.app.java.messages.Result;

public class MapReduceApplication {

    public static void main(String[] args) throws Exception {

        ActorSystem _system = ActorSystem.create("MapReduceApp");

        ActorRef master = _system.actorOf(new Props(MasterActor.class), "master");

        //non-default constructor
//        ActorRef master = _system.actorOf(new Props(new UntypedActorFactory() {
//            @Override
//            public Actor create() throws Exception {
//                return new MasterActor();
//            }
//        }));

        master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog");
        master.tell("Dog is man's best friend");
        master.tell("Dog and Fox belong to the same family");

        Thread.sleep(500);

        master.tell(new Result(), null);

        Thread.sleep(500);

        _system.shutdown();
        System.out.println("Java done!");
    }
}
