

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculateFortune extends Remote{
     public String calculate(String name,int age,String birthday) throws RemoteException;
}
