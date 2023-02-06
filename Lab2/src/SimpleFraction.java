import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a fraction with an integer numerator and an integer denominator.
 */
public class SimpleFraction implements Fraction {
  private final int numerator;
  private final int denominator;

  /**
   * Constructs a {@code SimpleFraction}.
   *
   * @param numerator   The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   * @throws IllegalArgumentException The fraction cannot be negative or undefined.
   */
  public SimpleFraction(int numerator, int denominator) throws IllegalArgumentException {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator " + denominator + " cannot be 0");
    } else if (numerator < 0 && denominator > 0) {
      throw new IllegalArgumentException("Numerator " + numerator + " cannot be negative.");
    } else if (denominator < 0 && numerator > 0) {
      throw new IllegalArgumentException("Denominator " + denominator
              + " cannot be negative.");
    } else if (numerator < 0 && denominator < 0) {
      numerator = numerator * -1;
      denominator = denominator * -1;
    }

    this.numerator = numerator;
    this.denominator = denominator;
  }

  @Override
  public Fraction add(Fraction other) {
    String otherFraction = other.toString();
    int otherNumerator = Integer.parseInt(otherFraction.substring(0,
            otherFraction.indexOf("/")));
    int otherDenominator = Integer.parseInt(otherFraction.substring(
            otherFraction.indexOf("/") + 1));
    return this.add(otherNumerator, otherDenominator);
  }

  @Override
  public Fraction add(int numerator, int denominator) {
    if (numerator < 0) {
      throw new IllegalArgumentException("Provided numerator cannot be negative.");
    }
    if (denominator <= 0) {
      throw new IllegalArgumentException("Provided denominator cannot be negative or zero.");
    }
    return new SimpleFraction((this.numerator * denominator + numerator * this.denominator),
            (this.denominator * denominator));
  }

  @Override
  public double getDecimalValue(int places) {
    BigDecimal bd = new BigDecimal(Double.toString((double) this.numerator / this.denominator));
    return bd.setScale(places, RoundingMode.HALF_UP).doubleValue();
  }

  @Override
  public String toString() {
    return this.numerator + "/" + this.denominator;
  }
}
