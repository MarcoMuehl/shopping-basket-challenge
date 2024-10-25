package model;

import discount.AbstractDiscount;
import repository.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 */
public class Basket {

    private List<Product> products;
    private Warehouse warehouse;
    private List<AbstractDiscount> discounts;
    //TODO User ID?

    public Basket(Warehouse warehouse) {
        this.products = new ArrayList<>();
        this.warehouse = warehouse;
        this.discounts = new ArrayList<>();
    }

    /**
     * Finds the model.Product for a scanned code and adds it to the basket.
     *
     * @param code the scanned productCode to find the product to add to the basket.
     */
    public void addProduct(String code) {
        Optional<Product> product = warehouse.getProductByCode(code);
        if (product.isPresent()) {
            products.add(product.get());
        } else {
            //TODO proper Handling
            System.out.println("model.Product " + code + " not found");
        }
    }

    /**
     * Add a discount to be applied
     * @param discount the discount to be added.
     */
    public void addDiscount(AbstractDiscount discount) {
        discounts.add(discount);
    }

    /**
     * Calculates the total price of items in the basket with discounts.
     *
     * @return the total price of all items in the basket, after applying the added discounts.
     */
    public double total() {
        double total = 0; //TODO: discuss if precision of double is sufficient (or if we want BigDecimal)
        List<Product> productsToProcess = this.products;

        //We need to look at each product individually, since it should be possible to apply multiple discounts
        for (Product product : productsToProcess) {
            double productPrice = product.price();

            //Apply all applicable discounts
            for (AbstractDiscount discount : discounts) {
                productPrice = discount.apply(product, productPrice);
            }

            total += productPrice;
        }

        return Math.round(total * 100.0) / 100.0; //only two decimals
    }

}
