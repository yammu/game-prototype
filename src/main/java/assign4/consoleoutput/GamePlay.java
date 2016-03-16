package assign4.consoleoutput;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import assign4.Avatar;
import assign4.Player;
import assign4.SequenceOfAvatars;

public class GamePlay {

  public static void main(String[] args) throws IOException {
    SequenceOfAvatars sequenceOfAvatars = new SequenceOfAvatars();
    List<Avatar> avatarSequence = sequenceOfAvatars.listOfAvatars(args[0]);
    Player player = new Player(avatarSequence, avatarSequence.get(0));

    System.out.println("\nCurrent Avatar is " + player.getAvatar()
                                                      .getClass());
    System.out.println("\nUse keys below to transform Avatars: \n 'a': PerformAction \n 'n': NextAvatar \n 'p': PreviousAvatar or \n 'e': exit ");

    char input = 'a';
    Scanner sc = new Scanner(System.in);

    while (input != 'e') {
      input = sc.next()
                .charAt(0);
      if (input == 'n') {
        player.transformToNext();
      } else if (input == 'p') {
        player.transformToPrevious();
      } else if (input == 'a') {
        System.out.println("Calling performAction on " + player.getAvatar()
                                                               .getClass());
        player.performAction();
      } else if (input == 'e')
        System.out.println("Game Over");
      else
        System.out.println("Invalid Option");
    }
    sc.close();
  }
}
