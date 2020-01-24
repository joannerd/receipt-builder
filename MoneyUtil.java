public class MoneyUtil {
  public static double roundNum(double num) {
    double result = Math.round(num * 100) / 100.00;
    return result;
  }

  public static String getCostStr(double cost) {
    String[] arr = String.valueOf(cost).split("\\.");
    if (arr[1].length() < 2) {
      return cost + "0";
    } else {
      return Double.toString(cost);
    }
  }
}