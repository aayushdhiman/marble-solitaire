import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of SimpleFraction.
 */
public class SimpleFractionTest {
  private Fraction oneThird;
  private Fraction oneFourth;
  private Fraction frac;

  @Before
  public void init() {
    this.oneThird = new SimpleFraction(1, 3);
    this.oneFourth = new SimpleFraction(1, 4);
    this.frac = new SimpleFraction(330, 542);

  }

  @Test
  public void testAddFractions() {
    assertEquals(new SimpleFraction(6, 9).toString(),
            oneThird.add(oneThird).toString());
  }

  @Test
  public void testAddInteger() {
    assertEquals(new SimpleFraction(9, 9).toString(),
            oneThird.add(2, 3).toString());
  }

  @Test
  public void testGetDecimalValue() {

    assertEquals(0.2500, oneFourth.getDecimalValue(4), 0.001);
    assertEquals(0.6, frac.getDecimalValue(1), 0.001);
  }
}