package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServidor extends Remote{
	
	public String filtroIMG(String imagen);
	
	public String filtroIMG2(String imagen);
	
}
