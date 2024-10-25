package discount;

import model.Product;

public class TenPercentDiscount extends AbstractDiscount {

    public TenPercentDiscount(String productCode) {
        super(productCode);
    }

    @Override
    public double apply(Product product, double currentPrice) {
        if (isApplicableTo(product)) {
            return currentPrice * 0.9;
        }
        return currentPrice;
    }
}