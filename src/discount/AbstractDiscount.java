package discount;

import model.Product;

/**
 * Abstract class for a Discount, providing base functionality.
 */

public abstract class AbstractDiscount {
    protected String productCode;

    public AbstractDiscount(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Checks, if the discount can be applied to the product.
     *
     * @param product the product to check
     * @return true: when discount is applicable
     * false: when discount is not applicable
     */
    protected boolean isApplicableTo(Product product) {
        return product.code().equals(this.productCode);
    }

    /**
     * Calculates the new price of a product, after trying to apply the discount.
     *
     * @param product      the product the discount should be applied for
     * @param currentPrice the current price of the product
     * @return the price after applying the discount
     */
    public abstract double apply(Product product, double currentPrice);
}
