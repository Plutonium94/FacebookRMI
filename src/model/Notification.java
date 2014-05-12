package model;

import model.enums.ActionEnum;
import model.user.PrivateUser;

public class Notification {
	private PrivateUser privateUser;
	private ActionEnum actionEnum;
	private String notification;
	
	public Notification(PrivateUser privateUser, ActionEnum actionEnum) {
		this.privateUser = privateUser;
		this.actionEnum = actionEnum;
		this.notification = this.privateUser.getPublicData().getName() + " " + this.actionEnum;
	}

	public PrivateUser getPrivateUser() {
		return privateUser;
	}

	public void setPrivateUser(PrivateUser privateUser) {
		this.privateUser = privateUser;
	}

	public ActionEnum getActionEnum() {
		return actionEnum;
	}

	public void setActionEnum(ActionEnum actionEnum) {
		this.actionEnum = actionEnum;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	
}
