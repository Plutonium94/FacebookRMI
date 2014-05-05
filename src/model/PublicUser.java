package model;

public class PublicUser {
	protected PublicData publicData;
	
	public PublicUser(PublicData publicData) {
		this.publicData = publicData;
	}

	public PublicData getPublicData() {
		return publicData;
	}

	public void setPublicData(PublicData publicData) {
		this.publicData = publicData;
	}
}
