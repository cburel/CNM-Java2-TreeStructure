import java.util.ArrayList;

/**
 * The ordered set of Person objects. Sorts alphabetically by name when adding a
 * Person to the ordered ArrayList.
 */
public class PersonOrderedSet extends PersonSet {

    /**
     * Adds a person to its ArrayList, then sorts alphabetically.
     */
    @Override
    public void add(Person p) {
        super.add(p);
        sort(people);
    }

    /**
     * Handles sorting people by name alphabetically
     * 
     * @param people The sorted ArrayList
     */
    private void sort(ArrayList<Person> people) {
        people.sort(null);
    }
}
