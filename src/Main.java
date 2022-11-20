import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final String menu = "A - Add  D - Delete  P - Print Q - Quit";
        boolean done = false;
        String cmd = "";
        do{
            displayList();
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd){
                case "A":
                    String item = SafeInput.getNonZeroLength(in, "Enter the item to add: ");
                    list.add(item);
                    break;
                case "D":
                    int index = SafeInput.getRangedInt(in, "Enter the item you want to remove: ",1,list.size());
                    list.remove(index-1);
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    boolean quit = SafeInput.getYNConfirm(in, "Do you want to quit?");
                    if (quit)
                        System.exit(0);
                    break;
            }

        } while (!done);

    }

    private static void displayList() {
        if(list.size() != 0) {

            for (int i = 0; i < list.size(); i++) {
                System.out.printf("\n%-3d%-30s", i + 1, list.get(i));

            }
        }
        else
            System.out.println("List is empty");
    }

}