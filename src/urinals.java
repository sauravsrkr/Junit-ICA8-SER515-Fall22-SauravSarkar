import java.io.IOException;
import java.util.Scanner;

/**
 * The urinals program implements an application that
 * simply provides the number of available urinals positions for the given input.
 *
 * @author Saurav Sakar
 */
public class urinals {
    public static void main(String[] args) throws IOException {
        checkUrinals urinals = new checkUrinals();
        while (true) {
            System.out.println("\n===========");
            System.out.println("1) Read from console \n2) Read from file\n3) Exit");
            System.out.print("Enter your option: ");
            Scanner sc = new Scanner(System.in);
            String next = sc.nextLine();
            switch (next) {
                case "1":
                    System.out.print("Provide input string: ");
                    String inputString = sc.nextLine();
                    if (!urinals.goodString(inputString)) {
                        System.out.println("Invalid input");
                        continue;
                    }
                    int count = urinals.getFreeUrinals(inputString);
                    System.out.print("Free urinals : " + count + "\n");
                    break;
                case "2":
                    String[] lines = urinals.readFromFile("src/urinal.dat");
//                String outFile = urinals.writeToFile(lines);
//                System.out.println("Output is written to " + outFile);
                    break;
                case "3":
                    System.out.println("Exit...");
                    System.exit(1);
            }
        }
    }


}