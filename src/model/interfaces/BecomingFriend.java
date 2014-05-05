package model.interfaces;

import model.PrivateData;
import model.PublicData;

public interface BecomingFriend {
	public void friendRequest(PublicData publicData);
	public String whoAreYou();
	public PrivateData acceptRequest(PublicData publicData, PrivateData privateData);
	public void denyRequest(PublicData publicData);
}
