package discount;

import model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * A Discount to
 */

public class BuyOneGetOneFreeDiscount extends AbstractDiscount {
    private final Map<String, Integer> productCounts;

    public BuyOneGetOneFreeDiscount(String productCode) {
        super(productCode);
        this.productCounts = new HashMap<>();
    }

    @Override
    public double apply(Product product, double currentPrice) {
        if (!isApplicableTo(product)) {
            return currentPrice;
        }

        //Update count for productCode
        productCounts.put(productCode, productCounts.getOrDefault(productCode, 0) + 1);

        int count = productCounts.get(productCode);

        if (count % 2 == 0) {
            return 0; //Freebie
        } else {
            return currentPrice; //First item of each pair is regular price
        }
    }
}
