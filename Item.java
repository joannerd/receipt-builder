public class Item extends MoneyUtil {
  private final double price;
  private final int count;
  private final String name;
  private final double taxRate;

  public Item(double price, int count, String name, double taxRate) {
    this.price = price;
    this.count = count;
    this.name = name;
    this.taxRate = taxRate;
  }

  public double calculateRoundedTax() {
    double result = Math.round(price * taxRate * 20.00) / 20.00;
    double unrounded = price * taxRate;
    if (unrounded - result > 0.01) {
      return Math.ceil(price * taxRate * 20.00) / 20.00;
    } else {
      return result;
    }
  }

  public double getCostWithTax() {
    return roundNum(count * calculateRoundedTax() + price);
  }

  public int getCount() {
    return count;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return this.getCount() + this.getName() + ": " + getCostStr(this.getCostWithTax());
  }
}