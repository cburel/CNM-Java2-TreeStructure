import java.util.Objects;

/**
 * The default Person class. Contains the info about a given person and allows
 * for manipulation of their data. Additionally overrides toString(), equals(),
 * and compareTo().
 */
public class Person implements Comparable<Person> {
    private String name;
    private double height, weight;

    /**
     * Constructor.
     * 
     * @param name   The name of the person being created
     * @param height The height of the person being created (cm)
     * @param weight The weight of the person being created (kg)
     */
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Fetches the name of a given person
     * 
     * @return The person's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of a given person
     * 
     * @param name The name to replace the old name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Fetches the height of a given person
     * 
     * @return The person's height in cm
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Sets the height of a given person
     * 
     * @param height The height to replace the old height. Should be in cm.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Fetches the weight of a given person
     * 
     * @return The person's weight in kg
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Sets the weight of a given person
     * 
     * @param weight The weight to replace the old weight. Should be in kg.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Pretty-prints the name, height, and weight of a person. Default is in metric.
     */
    @Override
    public String toString() {

        // print as database-ready string
        String output = String.format("%-10s %10.2f %20.2f", name, height, weight);

        return output;
    }

    /**
     * Overrides the default equals method. Determines whether one Object is the
     * same as another. Used in the contains method in PersonSet.
     */
    @Override
    public boolean equals(Object o) {

        // if there is no object, automatically false
        if (o == null) {
            return false;
        }

        // if the object is the same object as this, automatically true
        if (o == this) {
            return true;
        }

        // if the object isn't a Person, automatically false
        if (!(o instanceof Person)) {
            return false;
        }

        // if the above checks have passed, object is a person, so cast to person and
        // assign it to a new variable for additional comparison
        Person p = (Person) o;

        // if name, height, and weight are the same on both this object and the other
        // object, this entry is equal to the other
        if (p.name.equals(this.name) && p.height == this.height && p.weight == this.weight) {
            return true;
        }

        // check for equality conditions: name values are the same, height values are
        // the same, weight values are the same. returns false if any of these values do
        // not match. otherwise, returns true.
        return (Objects.equals(this.name, p.name) &&
                Double.compare(this.height, p.height) == 0 &&
                Double.compare(this.weight, p.weight) == 0);
    }

    /**
     * Overrides the default compareTo method. Determines whether a given Person is
     * the same as a current Person. Used in the sort method in PersonOrderedSet.
     */
    @Override
    public int compareTo(Person other) {

        // returns -1 if this.name < other.name (this preceeds other alphabetically),
        // returns 0 if this.name == other.name (this is equal to other),
        // returns 1 if this.name > other.name (this follows other)
        return this.name.compareTo(other.name);
    }
}
