package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Simulates a backend to store available products.
 */

public class Warehouse {

    private final List<Product> availableProducts;

    public Warehouse() {
        this.availableProducts = new ArrayList<>();;
        initProducts();
    }

    private void initProducts() {
        this.availableProducts.add(new Product("A0001", 12.99));
        this.availableProducts.add(new Product("A0002", 3.99));
    }

    /**
     *
     * @param code the product code of the product to get
     * @return an optional product
     */
    public Optional<Product> getProductByCode(String code) {
        return this.availableProducts.stream()
                .filter(product -> product.code().equals(code))
                .findFirst();
    }

    //TODO More CRUD-Operations if needed?
}
