package model;

import java.rmi.RemoteException;
import java.util.List;

public class MyUser extends PrivateUser {
	private static MyUser instance;
	private List<PublicUser> friendsRequestISent;
	private List<PublicUser> friendsRequestIReceived;

	private MyUser() throws RemoteException {
		super(new PublicData(), new PrivateData());
	}
	
	public static MyUser getInstance() {
		if(MyUser.instance==null) {
			try {
				MyUser.instance = new MyUser();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}
