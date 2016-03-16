package assign4;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class SequenceOfAvatarsTest {
  SequenceOfAvatars sequenceOfAvatars = new SequenceOfAvatars();

  @Test
  public void createAvatarFromString() {
    Avatar avatar = sequenceOfAvatars.createAvatarFromName("Bike");
    assertTrue(avatar instanceof Bike);
  }

  @Test
  public void createAnotherAvatarFromString() {
    Avatar avatar = sequenceOfAvatars.createAvatarFromName("Car");
    assertTrue(avatar instanceof Car);
  }

  @Test
  public void createAvatarGivenAnInvalidName() {
    Avatar avatar = sequenceOfAvatars.createAvatarFromName("invalid");
    assertNull(avatar);
  }

  @Test
  public void checkFileHasListOfStrings() throws IOException {
    String fileName = "inputFiles/AvatarNames";
    List<String> avatarNames = sequenceOfAvatars.listOfAvatarNames(fileName);
    assertEquals("Bike", avatarNames.get(0));
    assertEquals("Car", avatarNames.get(1));
    assertEquals("Plane", avatarNames.get(2));
  }

  @Test
  public void throwExceptionIfFileNotFound() {
    String fileName = "inputFiles/invalidFile";
    try {
      sequenceOfAvatars.listOfAvatarNames(fileName);
      fail("Should have thrown the exception because file is invalid");
    } catch (Exception e) {
    }
  }

  @Test
  public void throwExceptionIfFileIsEmpty() {
    String fileName = "inputFiles/emptyFile";
    try {
      sequenceOfAvatars.listOfAvatarNames(fileName);
      fail("Should have thrown an exception as the file is empty");
    } catch (Exception e) {
    }
  }

  @Test
  public void throwExceptionIfFileHasBlankLinesOnly() {
    String fileName = "inputFiles/fileWithBlanksLines";
    try {
      sequenceOfAvatars.listOfAvatarNames(fileName);
      fail("should have thrown exception when the file has blank lines");
    } catch (Exception e) {
    }
  }

  @Test
  public void firstElementOfListOfAvatarIsBike() throws IOException {
    String fileName = "inputFiles/AvatarNames";
    List<Avatar> listOfAvatar = sequenceOfAvatars.listOfAvatars(fileName);
    assertTrue(listOfAvatar.get(0) instanceof Bike);
  }

  @Test
  public void sizeOfListOfAvatarsFromFileIsFour() throws IOException {
    String fileName = "inputFiles/AvatarNames";
    List<Avatar> listOfAvatar = sequenceOfAvatars.listOfAvatars(fileName);
    assertEquals(4, listOfAvatar.size());
  }
}