package io.github.oliviercailloux.javagrade.graders;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class User {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
    RemoteTest rem = (RemoteTest) registry.lookup("RemoteTestJ2");
    while(true) {
      System.out.println("Tested: " + rem.test(0, 1));
    }
  }
}
