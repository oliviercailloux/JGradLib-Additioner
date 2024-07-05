package io.github.oliviercailloux.javagrade.graders;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTest extends Remote{
  int test(int secret, int id) throws RemoteException;
}
