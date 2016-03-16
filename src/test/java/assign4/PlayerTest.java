package assign4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

  Avatar car;
  Avatar bike;
  Player player;

  @Before
  public void setUp() {
    List<Avatar> sequenceOfAvatar = new ArrayList<Avatar>();
    bike = spy(new Bike());
    sequenceOfAvatar.add(bike);
    sequenceOfAvatar.add(car);
    player = new Player(sequenceOfAvatar, bike);
  }

  @Test
  public void actionOnPlayerIsSentToItsAvatar() {
    player.performAction();

    verify(bike, times(1)).performAction();
  }

  @Test
  public void avatarTransformsToNextAvatarInSequence() {
    player.transformToNext();
    assertEquals(car, player.getAvatar());
  }

  @Test
  public void avatarReturnsToItsOwnStateAfterTwiceNextTransformations() {
    player.transformToNext();
    player.transformToNext();
    assertEquals(bike, player.getAvatar());
  }

  @Test
  public void avatarTransformsToPreviousAvatarInSequence() {
    player.transformToPrevious();
    assertEquals(car, player.getAvatar());
  }

  @Test
  public void avatarReturnsToItsOwnStateAfterTwicePreviousTransformations() {
    player.transformToPrevious();
    player.transformToPrevious();
    assertEquals(bike, player.getAvatar());
  }
}