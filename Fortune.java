

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Fortune extends UnicastRemoteObject implements CalculateFortune{
    public List<String> names=new ArrayList<String>();
    
    Dictionary fortunepairs = new Hashtable(); 
    public String[] fortunes= {"You will get a partner in 2 years","you will die alone","You will have 10 twin babies","Never imagine to get a partner"};
	protected Fortune() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String calculate(String name,int age,String birthday) throws RemoteException {
		// TODO Auto-generated method stub
		
		
	   if(!(names.contains(name))) {
			int randd = (int)(Math.random() * 4) + 0;
			names.add(name);
		    fortunepairs.put(name, randd);
		
	   }
		
		String response="name: "+name;
		response+="\nage: "+age;
		response+="\nfortune: "+fortunes[(int) fortunepairs.get(name)];
		return response;
	}

}
