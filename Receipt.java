import java.util.List;
import java.util.stream.Collectors;

public class Receipt extends MoneyUtil {
  private final List<Item> lines;
  private final double totalTax;
  private final double totalPrice;

  public Receipt(List<Item> lines) {
    this.lines = lines;
    this.totalTax = roundNum(lines.stream()
      .map(item -> item.calculateRoundedTax())
      .mapToDouble(Double::doubleValue)
      .sum()
    );
    this.totalPrice = roundNum(lines.stream()
      .map(item -> item.getCostWithTax())
      .mapToDouble(Double::doubleValue)
      .sum()
    );
  }

  public List<Item> getLines() {
    return lines;
  }

  public double getTotalTax() {
    return totalTax;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  private String renderTotalTax() {
    return "Sales Taxes: " + getCostStr(getTotalTax());
  }

  private String renderTotalPrice() {
    return "Total: " + getCostStr(getTotalPrice());
  }

  @Override
  public String toString() {
    String linesString = lines.stream().map(item -> item.toString()).collect(Collectors.joining("\n"));
    String totalPriceString = renderTotalPrice();
    String totalTaxString = renderTotalTax();

    return String.join("\n", linesString, totalTaxString, totalPriceString);
  }
}