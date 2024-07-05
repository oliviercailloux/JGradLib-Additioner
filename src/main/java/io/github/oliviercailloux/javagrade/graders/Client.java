package io.github.oliviercailloux.javagrade.graders;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
  @SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) throws Exception {
    LOGGER.info("Starting client.");
    Registry registryJ2 = LocateRegistry.createRegistry(Registry.REGISTRY_PORT + 1);
    RemoteTest engine = new RemoteTestJ2();
    RemoteTest stub = (RemoteTest) UnicastRemoteObject.exportObject(engine, 0);
    registryJ2.rebind("RemoteTestJ2", stub);
    // Registry registryJ1 = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
    // Hello hello = (Hello)registryJ1.lookup("Hello");
    // hello.hello();
    // LOGGER.info("Ending client.");
    Thread.sleep(3000);
  }
}
