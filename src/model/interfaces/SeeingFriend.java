package model.interfaces;

import java.util.List;

import model.PublicData;
import model.Publication;
import model.enums.ActionEnum;

public interface SeeingFriend {
	public void publish(Publication publication);
	public void notifyAction(ActionEnum actionEnum);
	public String checkWall();
	public List<PublicData> friendSuggestion();
}
