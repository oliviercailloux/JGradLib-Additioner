package io.github.oliviercailloux.javagrade.graders;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    RemoteTest engine = new RemoteTestImpl();
    RemoteTest stub = (RemoteTest) UnicastRemoteObject.exportObject(engine, 0);
    registry.rebind("RemoteTestJ2", stub);
    Thread.sleep(3000);
    Thread.getAllStackTraces().keySet().forEach(thread -> {
      System.out.println("Thread: " + thread.getName() + " is daemon: " + thread.isDaemon());
    });
  }
}
