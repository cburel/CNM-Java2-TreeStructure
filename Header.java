/**
 * A class to handle writing the name, height, and weight header for an
 * ArrayList of people. Default is in metric.
 */
public class Header {

    String heightMeasure;
    String weightMeasure;

    /**
     * Constructor. Creates a header.
     * 
     * @param heightMeasure For printing height (cm)
     * @param weightMeasure For printing weight (kg)
     */
    public Header(String heightMeasure, String weightMeasure) {
        this.heightMeasure = heightMeasure;
        this.weightMeasure = weightMeasure;
    }

    /**
     * Pretty-prints the header to align with the name, height, weight info as
     * written in the toString method in Person.
     */
    @Override
    public String toString() {
        String output = String.format("%-10s %10s %20s", "Name", "Height " + heightMeasure,
                "Weight " + weightMeasure);

        return output;
    }
}
