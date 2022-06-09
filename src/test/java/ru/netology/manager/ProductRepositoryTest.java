package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(123, "Красная таблетка", 450, "Курпатов");
    Product product2 = new Book(134, "Магия утра", 360, "Чупина");
    Product product3 = new Smartphone(735, "Honor 50", 24900, "Huawei");
    Product product4 = new Smartphone(425, "Samsung Galaxy A73", 51000, "Samsung");
    Product product5 = new Smartphone(256, "Honor 30", 21900, "Huawei");

    @BeforeEach
    void save() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
    }

    @Test
    void shouldTestFindAll() {
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4, product5};

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldTestRemoveById() {
        repo.removeById(735);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4, product5};

        assertArrayEquals(expected, actual);
    }


}