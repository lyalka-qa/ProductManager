package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(123, "Красная таблетка", 450, "Курпатов");
    Product product2 = new Book(134, "Магия утра", 360, "Чупина");
    Product product3 = new Smartphone(735, "Honor 50", 24900, "Huawei");
    Product product4 = new Smartphone(425, "Samsung Galaxy A73", 51000, "Samsung");
    Product product5 = new Smartphone(256, "Honor 30", 21900, "Huawei");

    @BeforeEach
    void save() {
        manager.save(product1);
        manager.save(product2);
        manager.save(product3);
        manager.save(product4);
        manager.save(product5);
    }


    @Test
    void searchBy() {
        manager.searchBy("Honor");

        Product[] actual = manager.findAll();
        Product[] expected = {product3, product5};

        assertArrayEquals(expected, actual);
    }


}