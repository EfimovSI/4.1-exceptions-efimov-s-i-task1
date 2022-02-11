package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Product first = new Product(1, "First", 10);
    Product second = new Product(2, "Second", 20);
    Book third = new Book(3, "Third", 30, "John", 125, 1995);
    Book fourth = new Book(4, "Fourth", 40, "Smith", 199, 2002);
    TShirt fifth = new TShirt (5, "Fifth", 50, "red", "L");
    TShirt sixth = new TShirt (6, "Sixth", 60, "Green", "XL");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldRemoveByIdWhenExists() {
        repository.removeById(4);

        assertArrayEquals(new Product[]{first, second, third, fifth, sixth}, repository.findAll());
    }

    @Test
    void shouldThrowIfIdNotExist() {
        assertThrows(NotFoundException.class, ()-> {repository.removeById(15);});
    }
}