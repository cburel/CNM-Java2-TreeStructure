/**
 * The set of Person objects with height and weight measurements in imperial.
 * Converts measurements when adding to its ArrayList.
 */
public class PersonImperialSet extends PersonSet {

    /**
     * Handles measurement conversion, then adds a given Person to the imperial
     * ArrayList.
     */
    @Override
    public void add(Person p) {

        // convert cm to in
        p.setHeight(convertHeight(p.getHeight()));

        // convert kg to lb
        p.setWeight(convertWeight(p.getWeight()));

        // add to imperial ArrayList
        super.add(p);
    }

    /**
     * Converts the height of the Person to add from metric to imperial
     * 
     * @param height The height of the Person in cm
     * @return The height of the Person in inches
     */
    private double convertHeight(double height) {
        return height /= 2.54;
    }

    /**
     * Converts the weight of the Person to add from metric to imperial
     * 
     * @param weight The weight of the Person in kg
     * @return The weight of the Person in lb
     */
    private double convertWeight(double weight) {
        return weight *= 2.20462;
    }
}
