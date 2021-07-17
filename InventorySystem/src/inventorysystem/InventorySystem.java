/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

/**
 *
 * @author Moosa Raza1
 *
 */
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import java.util.ArrayList;

class Inventory {

    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Order> orders = new ArrayList<Order>();

    public void addInventory(Item item) {
        items.add(item);
    }

    public void addOrders(Order order) {
        orders.add(order);
    }

    public String getInventory() {
        return toString();
    }

    public String getOrders() {
        return orders.toString();
    }

    public String toString() {
        return items.toString();
    }
}

class Order {

    public ArrayList<Item> orderItems = new ArrayList<Item>();
    public static double orderTotal;
    public ArrayList<Double> orderSum = new ArrayList<Double>();

    public Order() {

    }

    public Order(double price, int quantity) {
        orderTotal = orderTotal + (price * quantity);
    }

    public void orderSum() {
        orderSum.add(orderTotal);
    }

    public void addItem(Item item) {
        orderItems.add(item);
    }

    public String toString() {
//        if (orderSum.size() == 0) {
//            for (int j = 0; j < orderItems.size(); j++) {
//                System.out.println(orderItems.get(j).toString());
//            }
//        } else {
//            for (int i = 0; i < orderSum.size(); i++) {
//                System.out.println("Order Total : " + orderSum.get(i));
//                for (int j = 0; j < orderItems.size(); j++) {
//                    System.out.println(orderItems.get(j).toString());
//                }
//            }
//        }
        return orderItems.toString();
    }
}

class Item {

    public String name;
    public double price;
    public int quantity;

    public Item() {

    }

    public Item(String name, double price, int quantity) {
        this.name = name;
        setQuantity(quantity);
        setPrice(price);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Name : " + name + ", " + " Price is : " + getPrice() + ", " + " Quantity is : " + getQuantity();
    }
}

class Clothes extends Item {

    public Clothes(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Clothes, " + super.toString();
    }
}

class Cosmetics extends Item {

    public Cosmetics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Cosmetics, " + super.toString();
    }
}

class Electronics extends Item {

    public Electronics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Electronics, " + super.toString();
    }
}

public class InventorySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> type = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();
        Order ord = new Order();
        Order or;
        Inventory invent = new Inventory();
        int selection1, selection2;
        selection1 = 0;
        String name;
        int quantity;
        double price;
        while (selection1 >= 0) {
            if (selection1 > 0) {
                System.out.println("");
            }
            selection1 = menu();
            if (selection1 == 1) {
                selection2 = subMenu();
                if (selection2 == 1) {
                    System.out.println("--- Clothes ---");
                    type.add("Clothes");
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    price = sc.nextDouble();
                    for (int i = 0; i < names.size(); i++) {
                        if (name.equals(names.get(i)) && price == prices.get(i)) {
                            quantity = quantities.get(i) + quantity;
                            quantities.remove(i);
                            names.remove(i);
                            prices.remove(i);
                            invent.items.remove(i);
                        }
                    }
                    names.add(name);
                    prices.add(price);
                    quantities.add(quantity);
                    Clothes clo = new Clothes(name, price, quantity);
                    invent.addInventory(clo);
                } else if (selection2 == 2) {
                    System.out.println("--- Cosmetics ---");
                    type.add("Cosmetics");
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    price = sc.nextDouble();
                    for (int i = 0; i < names.size(); i++) {
                        if (name.equals(names.get(i)) && price == prices.get(i)) {
                            quantity = quantities.get(i) + quantity;
                            quantities.remove(i);
                            names.remove(i);
                            prices.remove(i);
                            invent.items.remove(i);
                        }
                    }
                    names.add(name);
                    prices.add(price);
                    quantities.add(quantity);
                    Cosmetics co = new Cosmetics(name, price, quantity);
                    invent.addInventory(co);
                } else if (selection2 == 3) {
                    System.out.println("--- Electronics ---");
                    type.add("Electronics");
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    price = sc.nextDouble();
                    for (int i = 0; i < names.size(); i++) {
                        if (name.equals(names.get(i)) && price == prices.get(i)) {
                            quantity = quantities.get(i) + quantity;
                            quantities.remove(i);
                            names.remove(i);
                            prices.remove(i);
                            invent.items.remove(i);
                        }
                    }
                    names.add(name);
                    prices.add(price);
                    quantities.add(quantity);
                    Electronics elect = new Electronics(name, price, quantity);
                    invent.addInventory(elect);
                }
            } else if (selection1 == 2) {
                int count = 1;
                while (count == 1) {
                    System.out.println("");
                    System.out.println("You can add to your cart from following items");
                    System.out.println("");
                    System.out.println(invent.getInventory());
                    System.out.println("");
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    for (int i = 0; i < names.size(); i++) {
                        if (names.get(i).equals(name)) {
                            System.out.print("Enter Quantity: ");
                            quantity = sc.nextInt();
                            if (quantity <= quantities.get(i)) {
                                int quant = quantities.get(i) - quantity;
                                quantities.remove(i);
                                quantities.add(i, quant);
                                invent.items.remove(i);
                                if (type.get(i).equals("Clothes")) {
                                    Clothes clo = new Clothes(name, prices.get(i), quantities.get(i));
                                    invent.items.add(i, clo);
                                    Clothes CLO = new Clothes(name, prices.get(i), quantity);
                                    ord.addItem(CLO);
                                } else if (type.get(i).equals("Cosmetics")) {
                                    Cosmetics co = new Cosmetics(name, prices.get(i), quantities.get(i));
                                    invent.items.add(i, co);
                                    Cosmetics CO = new Cosmetics(name, prices.get(i), quantity);
                                    ord.addItem(CO);
                                } else if (type.get(i).equals("Electronics")) {
                                    Electronics elect = new Electronics(name, prices.get(i), quantities.get(i));
                                    invent.items.add(i, elect);
                                    Electronics ELECT = new Electronics(name, prices.get(i), quantity);
                                    ord.addItem(ELECT);
                                }
                                System.out.println("Your Order Details");
                                System.out.println("------------------");
                                or = new Order(prices.get(i), quantity);
                                System.out.println("Order total : " + Order.orderTotal);
                                System.out.println("Items : " + ord.toString());
                            } else {
                                System.out.println("Sorry! We are out of stocks");
                            }
                            break;
                        } else if (i == names.size() - 1) {
                            System.out.println("Sorry! This item is not in our stocks");
                        }
                    }
                    System.out.println("Enter");
                    System.out.println("1. For adding more items");
                    System.out.println("2. For completing order");
                    count = sc.nextInt();
                }
                if (count == 2) {
                    System.out.println("Your Order Details");
                    System.out.println("------------------");
                    System.out.println("Order total : " + Order.orderTotal);
                    System.out.println("Items : " + ord.toString());
                    System.out.println("");
                    System.out.println("Order Added");
//                    ord.orderSum();
//                    Order.orderTotal = 0;
                }
            } else if (selection1 == 3) {
                System.out.println("");
                System.out.println(invent.getInventory());
            } else if (selection1 == 4) {
                System.out.println("");
                System.out.println(ord.toString());
            } else if (selection1 == 5) {
                System.out.println("Items : ");
                System.out.println(invent.toString());
                System.out.println("Orders : ");
                System.out.println(ord.toString());
            } else if (selection1 == 6) {
                System.out.println("----------------------");
                System.out.println("Hope to see you again!");
                System.out.println("       Good Bye");
                System.exit(0);
            }
        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Welcome to Inventory System");
        System.out.println("---------------------------");
        System.out.println("Please make your selection");
        System.out.println("");
        System.out.println("1. Add Inventory");
        System.out.println("2. Add Order");
        System.out.println("3. Show Inventory");
        System.out.println("4. Show Orders");
        System.out.println("5. Show All details");
        System.out.println("6. Exit System");
        System.out.println("");
        System.out.print("> ");
        int select1 = sc.nextInt();
        return select1;
    }

    public static int subMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("You can add items from the following list");
        System.out.println("1. Clothes");
        System.out.println("2. Cosmetics");
        System.out.println("3. Electronics");
        System.out.println("");
        System.out.print("> ");
        int select2 = sc.nextInt();
        return select2;
    }
}
