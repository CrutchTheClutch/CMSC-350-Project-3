package project3;

import java.text.DecimalFormat;

/**
 * Filename:    Fraction
 * Author:      William Crutchfield
 * Date:        6/27/2017
 * Description: Defines the Fraction object.
 */
public class Fraction implements Comparable<Fraction> {

    private double numerator;
    private double denominator;
    private double value;

    /**
     * Default Fraction Constructor
     * @param fraction takes String of a fraction and assigns the value of numerator, denominator, and value.
     * @throws MalformedFractionException is thrown if there is an incorrect fraction
     */
    Fraction(String fraction) throws MalformedFractionException {
        String[] convert = fraction.split("/");     // converts fraction string to array
        if (convert.length != 2) throw new MalformedFractionException(fraction);    // throw error if fraction is incorrect
        numerator = Integer.parseInt(convert[0]);        // set numerator
        denominator = Integer.parseInt(convert[1]);      // set denominator
        this.value = numerator / denominator;       // set value to numerator/denominator
    }

    /**
     * Gets the value of the Fraction
     * @return numerator/denominator = value
     */
    private Double getValue() {
        return this.value;
    }

    /**
     * toString Method for Fraction
     * @return Returns the String representation of the Fraction
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        return df.format(numerator) + "/" + df.format(denominator);
    }

    /**
     * Is used to determine how fractions are compared for BST
     * @param frac fraction that is being compared
     * @return -1,0,1 depending if o is <,=,>
     */
    @Override
    public int compareTo(Fraction frac) {
        if (this.value == frac.getValue()) {
            return 0;
        }
        return this.value > frac.value ? 1 : -1;
    }
}
