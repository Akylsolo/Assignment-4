Project Overview
This project is a Java console application for managing a restaurant ordering system.

It uses Object-Oriented Programming (OOP) and JDBC to work with a PostgreSQL database.

The system allows managing customers, menu items (food and drinks), and orders.

OOP Design

Abstract classes: BaseEntity, MenuItem

Inheritance: FoodItem, DrinkItem

Interfaces: Validatable, PricedItem

Composition: Order contains Customer and OrderItem

Polymorphism: List<MenuItem> for food and drinks

CRUD Operations

Each entity supports:

create

getAll

getById

update

delete

All database operations use PreparedStatement.
CRUD Operations

Each entity supports:

create

getAll

getById

update

delete

All database operations use PreparedStatement.
