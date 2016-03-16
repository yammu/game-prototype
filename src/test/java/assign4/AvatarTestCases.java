package assign4;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public abstract class AvatarTestCases {
  abstract Avatar getAvatar();

  @Test
  public void test() {
    Avatar avatar = spy(getAvatar());
    avatar.performAction();

    verify(avatar, times(1)).performAction();
  }
}