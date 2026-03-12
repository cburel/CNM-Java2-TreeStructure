
/**
 * @author Celeste Burel
 * Date: 3/15/2026
 * Purpose: To practice implementing and using a binary tree.
 * Sources: N/A
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        // check to ensure a file name was entered in the terminal
        if (args.length == 0) {
            System.err.println("File name was not entered.");
            System.exit(1);
        }

        // prompt for the name of the file to read into the program
        String fileName = args[0];

        // test adding a person set and adding a person to the person set, then print
        PersonSet ps = new PersonSet();

        // test adding ordered personset
        PersonOrderedSet orderedPeople = new PersonOrderedSet();

        // add sorted binary tree set
        SortedTreeSet treeSet = new SortedTreeSet();

        // try to open the file
        try (Scanner fileReader = new Scanner(new File(fileName))) {

            // if there is info in the file...
            if (fileReader.hasNextLine()) {
                // skip the first line of the file (this line should contain the header strings)
                fileReader.nextLine();
            }

            // parse the info for each person in the file
            while (fileReader.hasNextLine()) {
                String name = fileReader.next();
                double height = fileReader.nextDouble();
                double weight = fileReader.nextDouble();

                // run this person through the PersonList add method, which will add them to the
                // list if they are not a duplicate
                Person person = new Person(name, height, weight);

                // add person to standard person set
                ps.add(person);

                // add person to ordered person set
                orderedPeople.add(person);

                // add person to tree person set. "clone" the data from person
                // var into a new Person to avoid the imperial set converting measurements
                // on person var, which will break the ordered set logic and cause duplicate
                // data in the ordered set.
                treeSet.add(new Person(person.getName(), person.getHeight(), person.getWeight()));
                // System.out.println(treeSet.toString());
            }
        } catch (FileNotFoundException e) {

            // print error message if the file by the given file name does not exist
            System.err.println("File " + fileName + " was not found!");

            // exit the program
            System.exit(1);
        }

        // TODO: convert this to print the tree set
        System.out.println();
        System.out.println(treeSet.toString());

        // write the ordered set info to an external file
        try {

            // set file name and create the writer
            FileWriter fileWriterOrdered = new FileWriter("hr_ordered_set_output.txt");

            // write the name, height, weight in metric to the file
            Header orderedHeader = new Header("(cm)", ("(kg)"));

            // write each person to the file
            fileWriterOrdered.write(orderedHeader.toString() + "\n");
            for (Person person : orderedPeople.people) {
                fileWriterOrdered.write(person.toString() + "\n");
            }

            // free resources
            fileWriterOrdered.close();

            // print confirmation message
            System.out.println("Ordered set file was successfully created.");
        } catch (IOException e) {

            // something went wrong. print exception info
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        }

    }
}
