package io.github.oliviercailloux.javagrade.graders;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
  public static void main(String[] args) throws Exception {
    System.out.println("Server starting.");
    /* Starts a thread that keeps stuff busy. */
    new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }).start();
    System.out.println("Server started.");
    Thread.getAllStackTraces().keySet().forEach(thread -> {
      System.out.println("Thread: " + thread.getName() + " is daemon: " + thread.isDaemon());
    });
  }
}
