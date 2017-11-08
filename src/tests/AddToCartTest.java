package tests;

import lab3.ShoppingCart;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddToCartTest {

    private static ShoppingCart shoppingCart;

    @BeforeClass
    public static void setUpClass()
    {
        shoppingCart = new ShoppingCart();
    }

    /*---------- Title length tests ----------*/
    @Test(expected=IllegalArgumentException.class)
    public void emptyTitle() {
        shoppingCart.addItem("", 99.99, 1, ShoppingCart.ITEM_REGULAR);
    }

    @Test
    public void legitTitles() {
        shoppingCart.addItem("A", 99.99, 1, ShoppingCart.ITEM_REGULAR);
        shoppingCart.addItem("Cola", 99.99, 1, ShoppingCart.ITEM_REGULAR);
        shoppingCart.addItem("SomethingVeryGoodINeedItRightNow", 99.99, 1, ShoppingCart.ITEM_REGULAR);
    }

    @Test(expected=IllegalArgumentException.class)
    public void tooLongTitle() {
        shoppingCart.addItem("SomethingTooGoodForMyShoppingCart", 99.99, 1, ShoppingCart.ITEM_REGULAR);
    }

    /*---------- Price value tests ----------*/
    @Test(expected=IllegalArgumentException.class)
    public void priceIsTooLow() {
        shoppingCart.addItem("Toothpaste", 0.009, 1, ShoppingCart.ITEM_REGULAR);
    }

    @Test
    public void priceIsOk() {
        shoppingCart.addItem("Shotgun", 400.75, 1, ShoppingCart.ITEM_REGULAR);
    }

    @Test(expected=IllegalArgumentException.class)
    public void priceIsTooHigh() {
        shoppingCart.addItem("VIP toothpick", 1000.01, 1, ShoppingCart.ITEM_REGULAR);
    }

    /*---------- Item quantity tests ----------*/
    @Test(expected=IllegalArgumentException.class)
    public void noQuantity() {
        shoppingCart.addItem("Shotgun for my wife", 400.75, 0, ShoppingCart.ITEM_REGULAR);
    }

    @Test
    public void acceptableQuantity() {
        shoppingCart.addItem("Cookie", 5.30, 1, ShoppingCart.ITEM_REGULAR);
        shoppingCart.addItem("Cookie", 5.30, 500, ShoppingCart.ITEM_REGULAR);
        shoppingCart.addItem("Cookie", 5.30, 1000, ShoppingCart.ITEM_REGULAR);
    }

    @Test(expected=IllegalArgumentException.class)
    public void tooMuchQuantity() {
        shoppingCart.addItem("Shotgun for my daughter", 400.75, 1001, ShoppingCart.ITEM_REGULAR);
    }

    /*---------- Item type tests ----------*/
    @Test(expected=IllegalArgumentException.class)
    public void tooLowItemTypeIndex() {
        shoppingCart.addItem("UFO blaster", 999.99, 10, -1);
    }

    @Test
    public void legitItemTypeIndexes() {
        shoppingCart.addItem("Milk", 10.99, 1, ShoppingCart.ITEM_REGULAR);
        shoppingCart.addItem("Beer 6-pack", 15.99, 1, ShoppingCart.ITEM_DISCOUNT);
        shoppingCart.addItem("A shoe", 50.99, 1, ShoppingCart.ITEM_SECOND_FREE);
        shoppingCart.addItem("'Pavlo Zibrow Golden Hits' CD", 1.99, 1, ShoppingCart.ITEM_FOR_SALE);
    }

    @Test(expected=IllegalArgumentException.class)
    public void tooHighItemTypeIndex() {
        shoppingCart.addItem("UFO blaster", 999.99, 10, 5);
    }

    /*---------- ShoppingCart capacity tests ----------*/
    @Test
    public void maxCapacity() {
        ShoppingCart capacityTestCart = new ShoppingCart();
        for (int i = 0; i < 99; i++) {
            capacityTestCart.addItem("A match", 0.01, 1, ShoppingCart.ITEM_REGULAR);
        }
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void overCapacity() {
        ShoppingCart capacityTestCart = new ShoppingCart();
        for (int i = 0; i < 100; i++) {
            capacityTestCart.addItem("A match", 0.01, 1, ShoppingCart.ITEM_REGULAR);
        }
    }
}
