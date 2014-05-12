package model.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import model.Notification;
import model.Publication;
import model.enums.ActionEnum;
import model.interfaces.SeeingFriend;
import model.user.MyUser;
import model.user.PrivateUser;

public class PrivateData  extends UnicastRemoteObject implements SeeingFriend {
	private static final long serialVersionUID = 1L;
	
	private List<Publication> wall;
	private List<PrivateUser> friends;
	
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

	@Override
	public void publish(Publication publication) {
		this.wall.add(publication);
	}

	@Override
	public void notifyAction(PrivateUser privateUser, ActionEnum actionEnum) {
		MyUser.getInstance().getNotifications().add(new Notification(privateUser,actionEnum));
	}

	@Override
	public String checkWall() {
		List<Publication> shortWall = new ArrayList<Publication>();
		int MAX_MSSG = 10;
		for(int i = 0; i < MAX_MSSG; i++) {
			shortWall.add(this.wall.get(this.wall.size()-1-i));
		}
		String toRet = "";
		for(Publication p : shortWall) {
			toRet += p;
		}
		return null;
	}

	@Override
	public List<PublicData> friendSuggestion() {
		List<PublicData> fS = new ArrayList<PublicData>();
		for(PrivateUser pU : this.friends) {
			fS.add(pU.getPublicData());
		}
		return fS;
	}
}
