import java.util.List;
import java.util.stream.Collectors;

public class ReceiptCreator {
  public static String createReceipt(List<String> itemLines) {
    List<Item> lines = itemLines.stream().map(itemLine -> ItemCreator.create(itemLine))
      .collect(Collectors.toList());
    Receipt receipt = new Receipt(lines);

    return receipt.toString();
  }
}