package io.github.oliviercailloux.javagrade.graders;

import java.rmi.Remote;

public interface Hello extends Remote {
  public void hello() throws java.rmi.RemoteException;
}
