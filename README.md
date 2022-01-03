# 132-Project-21F

Project Overview
In this project, you are expected to put your Java and Swing GUI development skills into designing
a graphical interface-based simulation for a restaurant that manages information about the
available menus, dishes, and table orders. The system can consist of two panels, including a panel
for the management and another panel for customers.
The programming project is different from the programming labs. In the labs, we have specified
exactly what to do. The main objective of the Programming Project is for you to have more practice
on large scale programming, to use the concepts you have learned so far, and to do research on
Swing GUI (using the principles described and materials provided in class). We only provide some
constraints here, and leave the other design/implementation choices to you. In this project, you are
expected to design and develop a large scale Java application from scratch. You are expected to
study Swing GUI components and their API, and use them in the GUI design of your program.
This document serves a guideline to describe some of the design choices, while the implementation
will be mainly up to you. You should consider software practices such as type hierarchies,
abstraction, code cleanliness, and documentation.
The project is an individual project. You can benefit from the course materials provided. You can
discuss the concepts with the TAs and with your friends, but cannot share any code. The project
code you submit must belong to you. You are not allowed to copy-paste any code from anywhere.
You need to type your code. Otherwise, plagiarism tools will find such similar code and
disciplinary action would be taken.
In the following, we describe the project (Restaurant Management Simulation with GUI) and
specify the constraints of this project. You are expected to make a decision for anything not
specified.
Menu Item
This is your base class for every item available on the Menu. You need to specialize your items
further to subclasses such as Drinks, Soups, Main Dishes, Condiments, etc. Create at least 5
different Menu Item types (more is encouraged), and at least 5 items for each type. Every Menu
Item has a price and availability. You also need to include images in the base classes.
Menu
Holds every Menu Item. The customer panel will use this class to display every item along with
their image, price and availability.

Menu Session
When a new customer arrives, we want to create a new session for her to track her orders.
Customers in a session should be able to select as many of a given item as they wish for their order
from the Menu, which is then saved in the session. Implement a graphical interface that lists the
menu items on the menu and items on the order, and shows the total price. If an item is unavailable
(discussed in the Stock section), show it grayed out.
Session Manager
You can think of sessions as tables in a restaurant. As restaurant management, we need to be able
to track sessions and add/remove their orders on demand. Write a graphical user interface and
show available tables and their associated sessions. Display a warning when all tables are filled
and do not accept any new sessions.
Note 1: Each customer can reserve/order for one or many persons. For example, a customer wants
to order food for five people. Then, there should be at least a table with five seats for satisfying
the request. But, when a customer wants to order for one person, finding a seat in a table with two
seats would be enough. You can consider different types of tables in your implementation. For
instance, four tables with 6 seats, 4 tables with two seats.
Note 2: You should consider a few policies for allocating the customers to the tables. First,
according to the number of persons in an order, the application should choose a suitable table. For
example, if the order is for one person, a table with 6 seats is not suitable. Second, when an order
is placed in a table, the other orders cannot be allocated to the same table. For example, suppose
that you have a customer who orders for one person and you allocate him to a table with three
seats. After that, you have a new order again for one person. Although there is an empty seat in
that table, you are not allowed to allocate the new customer to that table.
Whenever the application cannot find a table to place the current order, it should display a warning
to the customer and inform him that the tables are filled and we cannot accept any new customer.
Stock
Every Menu Item should have stock availability. Create a system that keeps track of stocks of
every item. Modify your Menu to decrease the stock count of items when ordered, and mark them
unavailable when out of stock (do not display this information to customers, just display the item
grayed out in the Menu).

Management
Restaurant managers would like to see statistics of how they are doing. Design a page that
displays a list of all orders and total sales.
While developing your project, you should:
● Apply object oriented programming concepts such as polymorphism, inheritance, type
hierarchies, exception handling, strings and file processing.
● Adhere to the principle of least access when designing your code.
● Make good use of Java Collections Framework.
● Use Java Swing GUI components to build your graphical user interface.
● Write clean code and comment on it well. You are free to structure your code however
you like, but you need to explain clearly what everything does.
○ Explain what each method does, what the method’s parameters are, and what
method returns.
○ You can also use Javadoc for documentation:
https://www.oracle.com/java/technologies/javase/javadoc-tool.html
Note: Please note that not providing sufficient documentation will lead to great
grade reduction, even if your code is perfect.

● You can add other classes if you think there is a need for them. For instance, you may
add Customer Class with name, age and totalPrice.
Design and implement a Graphical User Interface using the Java Swing Framework. You can
use components such as JTextField, JButton, JComboBox and JOptionPane to design your
GUI. You are free to use any layout but your GUI should be easy to understand and use.
During the demonstration of your project, you should show the execution of the following
operations via your Graphical User Interface.
Note: Your project can include two panels, one for the restaurant management and one for
the customers.
In the restaurant management panel:
● Register customers
● Show stock information
● Display the registered customers, sorted by the age of customers. In the case of the same
age, they should be sorted in descending order according to their total price of their orders.
● Print the total number of orders for each type of food.

In the customer panel:
● Display the empty table list and the number of empty seats in the restaurant at the moment
for reservation.
● Display the available items in the menu. For testing this part, you will ask to get an order
from a customer. Then, by adding items to the customer order list, remove them from the
stock. Afterwards, for the next customers the finished items should not be displayed.
● After the order is completed display the list of ordered items and the total price for the
ordered menu.