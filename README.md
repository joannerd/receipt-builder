# Receipt Builder
## Program Setup
> Open your terminal and run these commands to run the Receipt Builder Application.
```sh
$ javac App.java
$ java App
```
> Type in the name of the input file as instructed by the console (ex: input1.txt).
```sh
$ input1.txt
```

## Change Input
> Run the command below to input a new text file.
```sh
$ java App
```
> Input a new text file.
```sh
$ input2.txt
```

## Testing Setup
> Open your terminal and run these commands to open the test suite.
```sh
$ cd JUnitTest
$ mvn package
```

## Pseudocode Plan
1. Split input file into lines.
2. For each line:
    1. Split each input line's words into `wordsArray`.
        * First array element will always be the number of sold goods.
        * Last array element will always be the price.

    2. Create `itemString`.
        * Filter out elements that equal "at".
        * Join elements between array index 0 to -2 (inclusive).

    3. Initialize `totalTaxes` and `totalPrice` as 0.

    4. Calculate new price using the variables: `numberItems`, `itemPrice`, `taxRate`, `taxPrice`.
        * If `itemString` includes "imported", add import duty.
        * Calculate the price with taxes.
        * Calculate the current total tax amount.
        * Calculate the current total amount.

    5. Build and print `itemString`.
3. Build and print total taxes and total price lines.

## First Iteration: Main SalesTax Class
> Open your terminal and run these commands to view the project's first iteration.
```sh
$ cd V1_SalesTaxReceipt
$ javac SalesTax.java
$ java SalesTax
```