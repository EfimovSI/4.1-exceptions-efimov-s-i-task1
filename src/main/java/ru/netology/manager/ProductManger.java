package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManger {
    private final ProductRepository repository = new ProductRepository();

    public void save(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return repository.findById(id);
    }
}
