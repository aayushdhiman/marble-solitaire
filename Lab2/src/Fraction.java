/**
 * Represents a fraction.
 */
public interface Fraction {
  /**
   * Adds two fractions.
   *
   * @param other The fraction to add to this {@code Fraction}.
   * @return The sum of the two fractions as a {@code Fraction}.
   */
  Fraction add(Fraction other);

  /**
   * Adds two fractions.
   *
   * @param numerator   The numerator of the fraction to add to this {@code Fraction}.
   * @param denominator The denominator of the fraction to add to this {@code Fraction}.
   * @return The sum of the two fractions as a {@code Fraction}
   */
  Fraction add(int numerator, int denominator);

  /**
   * Finds the decimal value of the fraction to {@code places} decimal places.
   *
   * @param places The amount of decimal places to find the decimal value.
   * @return The decimal value of the fraction as a double.
   */
  double getDecimalValue(int places);
}
