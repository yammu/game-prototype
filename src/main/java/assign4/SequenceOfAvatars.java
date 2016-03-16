package assign4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceOfAvatars {

  protected  Avatar createAvatarFromName(String className) {
    try {
      return (Avatar) Class.forName("assign4." + className)
                           .newInstance();
    } catch (Exception e) {
      return null;
    }
  }

  protected  List<String> listOfAvatarNames(String fileName) throws IOException {
    BufferedReader avatarNamesFile = new BufferedReader(new FileReader(fileName));
    try {
      List<String> avatarNames = avatarNamesFile.lines()
                                                .filter(line -> !line.isEmpty())
                                                .collect(Collectors.toList());
      if (avatarNames.isEmpty())
        throw new RuntimeException();

      return avatarNames;
    } finally {
      avatarNamesFile.close();
    }
  }

  public  List<Avatar> listOfAvatars(String fileName) throws IOException {
    return listOfAvatarNames(fileName).stream()
                                      .map(avatar -> createAvatarFromName(avatar))
                                      .filter(avatar -> avatar != null)
                                      .collect(Collectors.toList());
  }
}