package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
    Repository repository = new Repository();
    ProductManager productManager = new ProductManager(repository);
    Book book1 = new Book(1, "1984", 400, "Джордж Оруэлл");
    Book book2 = new Book(2, "задача 3 тел", 500, "Лю Цисин");
    Book book3 = new Book(3, "Програмирование на Java для начинающих", 850, "Васильев Алексей");
    Book book4 = new Book(4, "Идеальный програмист", 641, "Мартин Роберт");
    Book book5 = new Book(5, "Python", 719, "Корягин Андрей");
    Smartphone smartphone1 = new Smartphone(6, "Samsung s20", 50_000, "Korea");
    Smartphone smartphone2 = new Smartphone(7, "Samsung s21", 70_000, "Korea");
    Smartphone smartphone3 = new Smartphone(8, "iPhone 13", 50_000, "China");

    @Test
    public void TestSearchForAddedProductsFromTheManager() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(book5);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] actual = productManager.searchBy("Samsung");
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearchForNonMatchingAddedProductsFromTheManager() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(book5);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] actual = productManager.searchBy("Netology");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveById() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(book5);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        repository.removeById(3);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book4, book5, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}