package tests;

import lab3.ShoppingCart;
import lab3.ShoppingCart.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculateDiscountTest {

    private Item item;
    private int expected;

    public CalculateDiscountTest(Item item, int expected) {
        this.item = item;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                /*---------- Discount for REGULAR type ----------*/
                {new Item("smth", 100.00, 5, ShoppingCart.ITEM_REGULAR),  0},
                /*---------- Discount for SECOND FREE type ----------*/
                {new Item("smth", 100.00, 1, ShoppingCart.ITEM_SECOND_FREE),  0},
                {new Item("smth", 100.00, 8, ShoppingCart.ITEM_SECOND_FREE),  50},
                /*---------- Discount for DISCOUNT items tests ----------*/
                {new Item("smth", 100.00, 1, ShoppingCart.ITEM_DISCOUNT),  10},
                {new Item("smth", 100.00, 10, ShoppingCart.ITEM_DISCOUNT),  20},
                {new Item("smth", 100.00, 60, ShoppingCart.ITEM_DISCOUNT),  50},
                /*---------- Discount for FOR SALE items ----------*/
                {new Item("smth", 100.00, 1, ShoppingCart.ITEM_FOR_SALE),  80},
                {new Item("smth", 100.00, 200, ShoppingCart.ITEM_FOR_SALE),  80},
                /*---------- Max possible discount test ----------*/
                {new Item("smth", 100.00, 800, ShoppingCart.ITEM_FOR_SALE),  80},
                {new Item("smth", 100.00, 200, ShoppingCart.ITEM_SECOND_FREE),  70},
                {new Item("smth", 100.00, 300, ShoppingCart.ITEM_SECOND_FREE),  80},
                {new Item("smth", 100.00, 900, ShoppingCart.ITEM_SECOND_FREE),  80}
        });

    }

    @Test
    public void discountTest()
    {
        assertEquals(expected, ShoppingCart.calculateDiscount(item));
    }

}
