package model.user;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import model.Notification;
import model.data.PrivateData;
import model.data.PublicData;

public class MyUser extends PrivateUser {
	private static MyUser instance;
	private List<PublicUser> friendsRequestISent;
	private List<PublicUser> friendsRequestIReceived;
	private List<Notification> notifications;

	private MyUser() throws RemoteException {
		super(new PublicData(), new PrivateData());
		this.friendsRequestISent = new ArrayList<PublicUser>();
		this.friendsRequestIReceived = new ArrayList<PublicUser>();
		this.notifications = new ArrayList<Notification>();
	}
	
	public static MyUser getInstance() {
		if(MyUser.instance==null) {
			try {
				MyUser.instance = new MyUser();
			} catch (RemoteException e) {
			}
		}
		return MyUser.instance;
	}

	public List<PublicUser> getFriendsRequestISent() {
		return friendsRequestISent;
	}

	public void setFriendsRequestISent(List<PublicUser> friendsRequestISent) {
		this.friendsRequestISent = friendsRequestISent;
	}

	public List<PublicUser> getFriendsRequestIReceived() {
		return friendsRequestIReceived;
	}

	public void setFriendsRequestIReceived(List<PublicUser> friendsRequestIReceived) {
		this.friendsRequestIReceived = friendsRequestIReceived;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}
