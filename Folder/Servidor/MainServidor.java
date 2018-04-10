package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.IServidor;
import common.Utils;

public class MainServidor {
	
	public static void main(String[] args) throws Exception {
		Utils.setCodeBase(IServidor.class);
		
		Servidor servidor = new Servidor();
		IServidor remote = (IServidor)UnicastRemoteObject.exportObject(servidor, 8080);
		
		Registry registry  = LocateRegistry.getRegistry();
		registry.rebind("Servidor", remote);
		
		System.out.println("Servidor Listo, presione enter para terminar");
		System.in.read();
		
		registry.unbind("Servidor");
	}

}
