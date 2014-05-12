package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import model.data.PrivateData;
import model.data.PublicData;
import model.interfaces.BecomingFriend;
import model.user.MyUser;

public class RMIFacebook {
	public static void main(String[] args) throws RemoteException {
		
		// Creer mon user
		MyUser mU = MyUser.getInstance();
		PrivateData prD = mU.getPrivateData();
		PublicData puD = mU.getPublicData();
		
		puD.setName("Mathias");
		puD.setIntroduction("Etudiant de Polytech");

		// S'inscrire au registry
		Registry reg = java.rmi.registry.LocateRegistry.createRegistry(1099);
		BecomingFriend bF = (BecomingFriend) puD;
		reg.rebind("Mathias", bF);
		
		// Lister les utilisateurs connectes
		String[] list = reg.list();
		for(String l : list) {
			System.out.println(l);
			/*try {
				Remote remote = reg.lookup(l); // 'Mathias'
			} catch (NotBoundException e) {
				e.printStackTrace();
			}*/
		}
	}
}
