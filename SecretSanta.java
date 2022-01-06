import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecretSanta {

  public static void main(String[] args) throws IOException {
    ArrayList<String> people = new ArrayList<>();

    System.out.println("\n\nWelcome to Secret Santa! Type a name you want added to the list, once" +
            " all names are added type \"Done\".");
    System.out.println("==============================================================================" +
            "===================");
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
      String name = scan.next();
      if (name.equals("Done")) {
        break;
      } else {
        people.add(name);
      }
    }
    System.out.println("Great! Now to draw a name type \"DRAW\" then press enter, repeat if you draw your name." +
            " Once you draw a name that isn't yours, type \"Continue\" and pass it to your neighbor!");
    while (!people.isEmpty()) {
      String cmd = scan.next();
      if (cmd.equals("DRAW")) {
        if (people.size() == 1) {
          System.out.println(people.get(0));
          System.out.println("You have just played Secret Santa!");
          break;
        } else {
          int flag = 0;
          while (flag != 1) {
            int choice = (int) (Math.random() * people.size());
            System.out.println(people.get(choice));
            if (scan.next().equals("Continue")) {
              for (int i = 0; i < 100; i++) {
                System.out.println();
              }
              System.out.println("To draw a name type \"DRAW\" then press enter, repeat if you draw your name." +
                      " Once you draw a name that isn't yours, type \"Continue\" and pass it to your neighbor!");
              people.remove(choice);
              flag = 1;
            }
          }
        }
      }
    }

  }
}
