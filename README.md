# Inventory-Management-System

## Abstract

The Inventory Management System is a java application that takes inventory list, customer order and payment method as input, verifies the order against available stock in the inventory, and calculates the bill.
#### **Input files(in CSV format)**
* **Inventory** contains a list of items in the stock, their respective Category (e.g. Dairy, Beverage, Bakery etc.), and the count of items permissible to buy from each category.
* **Customer Order** contains a list of items and their required quantities.
* **Card Numbers** is a list of all previous customers' card numbers.


### Design Patterns
1) Factory Design Pattern
2) Chain of Responsibility

Factory Design Pattern has been used to write to the output/error files as there are different types of files that need to be written to in different scenarios, but they have the same implementation and behaviour.

Chain of Responsibility has been used to  perform card validation in sequential order by chain handlers.
