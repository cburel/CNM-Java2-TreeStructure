
/**
 * @author Celeste Burel
 * Date: 3/1/2026
 * Purpose: To practice inheritance/using interfaces.
 *      Part 2: To create and instantiate two different types
 *      of person sets and write each of them to their own
 *      output file.
 * Sources: N/A
 */

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:

Q1: Car and Engine are related
by which, Inheritance or Composition?
-- Following the "is-a" = inheritence vs "has-a" = composition rule,
a car has an engine, so they are related by composition

Q2: Color and Red are related
by which, Inheritance or Composition?
-- Red is a color; inheritence

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
-- Shirt is a kind of clothing; inheritence

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
-- Desk is a piece of furniture; inheritence

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
-- CellPhone has a battery; composition
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

        // test adding imperial measurement personset
        PersonImperialSet imperialPeople = new PersonImperialSet();

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

                // add person to imperial measurement person set. "clone" the data from person
                // var into a new Person to avoid the imperial set converting measurements
                // on person var, which will break the ordered set logic and cause duplicate
                // data in the ordered set.
                imperialPeople.add(new Person(person.getName(), person.getHeight(), person.getWeight()));
            }
        } catch (FileNotFoundException e) {

            // print error message if the file by the given file name does not exist
            System.err.println("File " + fileName + " was not found!");

            // exit the program
            System.exit(1);
        }

        // write the imperial set info to an external file
        try {

            // set file name and create the writer
            FileWriter fileWriterImperial = new FileWriter("hr_imperial_set_output.txt");

            // write the name, height, weight in imperial measurements to the file
            Header imperialHeader = new Header("(in)", ("(lb)"));

            // write each person to the file
            fileWriterImperial.write(imperialHeader.toString() + "\n");
            for (Person person : imperialPeople.people) {
                fileWriterImperial.write(person.toString() + "\n");
            }

            // release resources
            fileWriterImperial.close();

            // print confirmation message
            System.out.println("Imperial set file was successfully created.");
        } catch (IOException e) {

            // something went wrong. print exception info
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        }

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
