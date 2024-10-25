import discount.BuyOneGetOneFreeDiscount;
import discount.TenPercentDiscount;
import model.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    private Warehouse warehouse;
    private Basket basket;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        basket = new Basket(warehouse); //already inits the products
    }

    /**
     * TODO Add more documentation for test reports e.g. with Allure
     */
    @Test
    void testTotalWithBuyOneGetOneFreeDiscount() {
        basket.addDiscount(new BuyOneGetOneFreeDiscount("A0002"));

        addThreeProducts();

        double expectedTotal = 16.98;

        assertEquals(expectedTotal, basket.total(), "Total should be " + expectedTotal + " after applying Discounts.");
    }

    /**
     * TODO Documentation for test reports e.g. with Allure
     */
    @Test
    void testTotalWithTenPercentDiscount() {
        basket.addDiscount(new TenPercentDiscount("A0001"));

        addThreeProducts();

        double expectedTotal = 19.67;

        assertEquals(expectedTotal, basket.total(), "Total should be " + expectedTotal + " after applying Discounts.");
    }

    /**
     * TODO Documentation for test reports e.g. with Allure
     */
    private void addThreeProducts() {
        //Scan Products
        basket.addProduct("A0002");
        basket.addProduct("A0001");
        basket.addProduct("A0002");
    }

    /**
     * TODO Documentation for test reports e.g. with Allure
     */
    @Test
    void testNoDiscount() {
        addThreeProducts();

        double expectedTotal = 20.97;

        assertEquals(expectedTotal, basket.total(), "Total should be " + expectedTotal);
    }

    /**
     * TODO Documentation for test reports e.g. with Allure
     */
    @Test
    void testMultipleDiscounts() {
        basket.addDiscount(new BuyOneGetOneFreeDiscount("A0002"));
        basket.addDiscount(new TenPercentDiscount("A0001"));

        addThreeProducts();

        double expectedTotal = 15.68;

        assertEquals(expectedTotal, basket.total(), "Total should be " + expectedTotal + " after applying Discounts.");
    }

    /**
     * TODO Documentation for test reports e.g. with Allure
     */
    @Test
    void testMultipleDiscountsOnSameProduct() {
        basket.addDiscount(new BuyOneGetOneFreeDiscount("A0002"));
        basket.addDiscount(new TenPercentDiscount("A0002"));

        addThreeProducts();

        double expectedTotal = 16.58;

        assertEquals(expectedTotal, basket.total(), "Total should be " + expectedTotal + " after applying Discounts.");
    }
}
