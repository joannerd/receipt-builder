import java.util.Arrays;

public class ItemCreator {
  static String[] taxExemptItems = new String[] { "book", "chocolate", "chocolates", "pills" };

  public static Item create(String itemLine) {
    String[] words = itemLine.split(" ");

    int itemCount = Integer.parseInt(words[0]);
    double itemPrice = Double.parseDouble(words[words.length - 1]);

    // for loop starts at i = 1 because the first element of `words` is the itemCount
    // for loop ends at i = words.length - 2 because the last element of `words` is the itemPrice
    double itemTaxRate = 0.10;
    String itemName = "";
    for (int i = 1; i < words.length - 1; i++) {
      String word = words[i];

      // remove tax rate if the item is exempt
      if (Arrays.asList(taxExemptItems).contains(word))
        itemTaxRate -= 0.10;

      // add import duty to imported items
      if (word.equals("imported"))
        itemTaxRate += 0.05;

      // add to itemName unless we've iterated to the last word
      itemName += word.equals("at") ? "" : " " + word;
    }

    return new Item(itemPrice, itemCount, itemName, itemTaxRate);
  }
}