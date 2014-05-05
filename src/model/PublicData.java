package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import model.interfaces.BecomingFriend;

public class PublicData  extends UnicastRemoteObject implements BecomingFriend {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String introduction;
	
	public PublicData()  throws RemoteException {
		this("","");
	}
	public PublicData(String name, String introduction)  throws RemoteException {
		super();
		this.name = name;
		this.introduction = introduction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public void friendRequest(PublicData publicData) {
		List<PublicUser> received = MyUser.getInstance().getFriendsRequestIReceived();
		PublicUser pU = new PublicUser(publicData);
		if(!received.contains(pU)) {
			received.add(pU);
		}
	}
	@Override
	public String whoAreYou() {
		return "My name is " + this.name + ".\nLet me introduce myself :\n" + this.introduction;
	}
	@Override
	public PrivateData acceptRequest(PublicData publicData, PrivateData privateData) {
		PrivateUser pU = new PrivateUser(publicData, privateData);
		// Comparing to actual friends
		List<PrivateUser> friends = MyUser.getInstance().getPrivateData().getFriends();
		if(friends.contains(pU)) {
			return null;
		}
		// Comparing to friends request sent
		List<PublicUser> friendsRequest = MyUser.getInstance().getFriendsRequestISent();
		if(friendsRequest.contains(pU)) {
			friendsRequest.remove(pU);
			MyUser.getInstance().getPrivateData().getFriends().add(pU);
			return MyUser.getInstance().getPrivateData();
		} else {
			return null;
		}
	}
	@Override
	public void denyRequest(PublicData publicData) {
		PublicUser pU = new PublicUser(publicData);
		// Comparing to friends request sent
		List<PublicUser> friendsRequest = MyUser.getInstance().getFriendsRequestISent();
		if(friendsRequest.contains(pU)) {
			friendsRequest.remove(pU);
		}
	}
}
