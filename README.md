OOP task for moving to phase 1 MJC school

```
Code Exercise
Define the class called Euro that represents financial data. Take into account
J. Bloch, 3rd ed., Item 60: Avoid float and double if exact answers are required. Let's
assume that the int range is sufficient to process financial data expressed in cents.
Define the class called Product that represents a product.
Class fields:
● name,
● price in euro.
Method(s):
● toString( ) – converting of an object to a string in the csv–format: each field, separated
by the ";" symbol.
Define the abstract superclass AbstractPurchase, describing the product purchase
and implementing interface Comparable<AbstractPurchase>.
Superclass fields:
● product,
● number of purchased units.
Methods:
● getCost( ) – returns a purchase cost rounded down to 1.00 euro;
● toString( ) – returns a string representation of a purchase in the csv–format: each non
constant field and the purchase cost, separated by the ";" symbol.
● compareTo(AbstractPurchase purchase) – compares purchases for sorting by the cost
decreasing.
Define the first subclass for the purchase with a price discount for every unit of
the product purchased and override necessary methods.
Define the second subclass for the purchase with a discount to be presented if the
number of purchased units is greater than the given subclass constant. A discount rate
is given by the percent from the purchase cost. Override necessary methods.
Define the third subclass for the purchase with an addition for transport expenses
and override necessary methods. Transport expenses do not depend on the number of
purchased units.
Define the Runner class and implement the following subtasks:
1. Create a unique product for purchasing.
2. Create an array for 6 objects (2 instances of every subclass by general-purpose
   constructors).
3. Print the array content to the console (one element per line).
4. Sort an array by the cost in descending order with the method sort( ) of the class
   Arrays.
5. Print the array content to the console (one element per line).
6. Print the minimum cost of purchase.
   Example:
   Minimum cost = 2.00
7. Create the method int search(Purchase[] purchases), where find an index of some
   purchase with cost equal to 5.00 euros using the method binarySearch( ) of the class
   Arrays. Print the found purchase or a message about the failed search.
   Create unit tests for task entities.
   Remarks and restrictions
   – All data are correct. Do not validate input arguments in constructors and methods.
   – Take into account that the cost in all subclasses must be rounded down (i.e. to the
   nearest lower) to 1 euro.
   Example. Costs from the semi-open range [7.00; 8.00) are rounded down to 7.00 euros.
   – Examples of cost calculation in subclasses (financial data are presented in cents):
1) let the discount in the price for each unit of product be 50, price 300, quantity 2;
   then cost = (300 - 50) * 2 = 500.
2) let discount percentage be 5.825, price 500, quantity 20, quantity to be exceeded 15;
   then cost = 500 * 20 * (1 - 5.825/100) = 9418 (cost is integer in cents!), since 20 > 15.
3) let price be 300, quantity 2, addition for transport expenses 200;
   then cost = 300 * 2 + 200 = 800.
   – Check on copy-paste at the cost calculation. If yes, then try to get rid of it.
   – The string representation of financial data is d+.dd, i.e. d+ for euros and strictly
   2 digits for cents.
```