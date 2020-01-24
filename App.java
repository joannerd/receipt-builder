import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please type in the name of the input file. ex: input1.txt");
    String inputFile = keyboard.next();
    keyboard.close();

    List<String> lines = new ArrayList<String>();

    try (Scanner scanner = new Scanner(new File("./textfiles/" + inputFile))) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File Doesn't Exist");
    }

    String calculatedReceipt = ReceiptCreator.createReceipt(lines);
    System.out.println(calculatedReceipt);
  }
}