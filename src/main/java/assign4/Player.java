package assign4;

import java.util.List;

public class Player {
  Avatar avatar;
  List<Avatar> sequenceOfAvatars;

  public Player(List<Avatar> listOfAvatars, Avatar aAvatar) {
    sequenceOfAvatars = listOfAvatars;
    avatar = aAvatar;
  }

  public void performAction() {
    avatar.performAction();
  }

  public Avatar getAvatar() {
    return avatar;
  }

  public void transformToNext() {
    int index = sequenceOfAvatars.indexOf(avatar);
    int nextIndex = (index + 1) % sequenceOfAvatars.size();
    avatar = sequenceOfAvatars.get(nextIndex);
  }

  public void transformToPrevious() {
    int index = sequenceOfAvatars.indexOf(avatar);
    int nextIndex = (index + sequenceOfAvatars.size() - 1)
        % sequenceOfAvatars.size();
    avatar = sequenceOfAvatars.get(nextIndex);
  }
}