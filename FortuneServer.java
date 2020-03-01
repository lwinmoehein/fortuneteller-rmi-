import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class FortuneServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// TODO Auto-generated method stub
		Fortune fortune=new Fortune();
		Naming.rebind("rmi://localhost:1099/fortune", fortune);
		System.out.println("server started");

	}

}
