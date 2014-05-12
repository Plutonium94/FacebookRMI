package model.interfaces;

import java.util.List;

import model.Publication;
import model.data.PublicData;
import model.enums.ActionEnum;
import model.user.PrivateUser;

public interface SeeingFriend extends java.rmi.Remote {
	public void publish(Publication publication) throws java.rmi.RemoteException;
	public void notifyAction(PrivateUser privateUser, ActionEnum actionEnum) throws java.rmi.RemoteException;
	public String checkWall() throws java.rmi.RemoteException;
	public List<PublicData> friendSuggestion() throws java.rmi.RemoteException;
}
