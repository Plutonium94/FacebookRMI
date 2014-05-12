package model.user;

import model.data.PrivateData;
import model.data.PublicData;

public class PrivateUser extends PublicUser {
	protected PrivateData privateData;
	
	public PrivateUser(PublicData publicData, PrivateData privateData) {
		super(publicData);
		this.privateData = privateData;
	}

	public PrivateData getPrivateData() {
		return privateData;
	}

	public void setPrivateData(PrivateData privateData) {
		this.privateData = privateData;
	}
}
