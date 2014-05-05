package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import model.enums.ActionEnum;
import model.interfaces.SeeingFriend;

public class PrivateData  extends UnicastRemoteObject implements SeeingFriend {
	private static final long serialVersionUID = 1L;
	
	private List<Publication> wall;
	private List<PrivateUser> friends;
	private List<PrivateData> notifications;
	
	public PrivateData()  throws RemoteException {
		this(new ArrayList<Publication>(), new ArrayList<PrivateUser>());
	}

	public PrivateData(List<Publication> wall, List<PrivateUser> friends)  throws RemoteException {
		super();
		this.wall = wall;
		this.friends = friends;
	}

	public List<Publication> getWall() {
		return wall;
	}

	public void setWall(List<Publication> wall) {
		this.wall = wall;
	}

	public List<PrivateUser> getFriends() {
		return friends;
	}

	public void setFriends(List<PrivateUser> friends) {
		this.friends = friends;
	}

	public List<PrivateData> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<PrivateData> notifications) {
		this.notifications = notifications;
	}

	@Override
	public void publish(Publication publication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAction(ActionEnum actionEnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String checkWall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PublicData> friendSuggestion() {
		// TODO Auto-generated method stub
		return null;
	}
}
