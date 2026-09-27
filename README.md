# Inventory Management System

A console application for managing the stock of a small shop and the orders placed
against it. I wrote this in 2021 as a university project while learning Java, and it
is here as a record of that work rather than as an example of how I write code today.

## What it does

The program opens with a menu and keeps running until you choose to exit:

- **Add inventory.** Items belong to one of three categories, clothes, cosmetics or
  electronics, and each has a name, a price per unit and a quantity. Adding an item
  that already exists at the same price increases its quantity instead of creating a
  duplicate entry.
- **Add an order.** You pick items from the stock by name and enter a quantity. The
  program checks that enough is in stock, reduces the inventory accordingly and keeps
  a running order total. If the quantity is not available it says so and leaves the
  stock untouched.
- **Show inventory**, **show orders**, or **show everything at once.**

## How it is built

Everything lives in one file, `InventorySystem.java`, with five classes in it. `Item`
holds a name, price and quantity, and `Clothes`, `Cosmetics` and `Electronics` extend
it, each overriding `toString` to print its own type. `Inventory` holds the list of
items, and `Order` collects the items of a purchase and keeps the total.

Plain Java, no external libraries. The project was created in NetBeans, so it builds
with Ant through the included `build.xml`.

## Running it

Open the project in NetBeans and run it, or from the command line:

```
cd InventorySystem
ant run
```

## What I would change today

The inventory only exists while the program runs, so everything is gone once you
exit. The state is held twice, once in the `Inventory` object and again in four
parallel `ArrayList`s for names, prices, quantities and types, which is what makes
the add and order logic as long as it is. A single list of items would replace all
of that. `orderTotal` is static, so it belongs to the class rather than to an order,
which means a second order would continue counting from the first one's total. There
are also no tests, and the same twenty lines are repeated three times for the three
item categories.

If I rebuilt it now I would keep one list of items, give `Order` its own total,
separate the menu handling from the inventory logic, save the stock to a file
between runs, and write tests for the stock checks.
