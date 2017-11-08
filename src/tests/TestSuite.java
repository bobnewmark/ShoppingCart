package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {AddToCartTest.class, CalculateDiscountTest.class})
public class TestSuite {
}
