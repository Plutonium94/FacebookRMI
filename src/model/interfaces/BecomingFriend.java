package model.interfaces;

import model.data.PrivateData;
import model.data.PublicData;

public interface BecomingFriend extends java.rmi.Remote {
	public void friendRequest(PublicData publicData) throws java.rmi.RemoteException;
	public String whoAreYou() throws java.rmi.RemoteException;
	public PrivateData acceptRequest(PublicData publicData, PrivateData privateData) throws java.rmi.RemoteException;
	public void denyRequest(PublicData publicData) throws java.rmi.RemoteException;
}
