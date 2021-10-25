//java.util.Objects imported for checking if strings, integers, etc. are equal
//Scanner imported for user input
import java.util.Objects;
import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean isLooping = true, notValidCapacity = true;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        String capacityNumber, pakuriName, menuSelection;
        //do-while loop to check if capacity entered by user is made up of only numerical characters, also ensures negative integers are not accepted
        do {
            System.out.print("Enter max capacity of the Pakudex: ");
            capacityNumber = scnr.next();
            for (int i = 0; i < capacityNumber.length(); i++) {
                //checks to see if every character in the entered string is a numerical character
                if (capacityNumber.charAt(i) == '0'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '1'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '2'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '3'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '4'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '5'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '6'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '7'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '8'){
                    notValidCapacity = false;
                } else if (capacityNumber.charAt(i) == '9'){
                    notValidCapacity = false;
                } else {
                    //if capacity entered by the user has a letter/special character/anything that's not a numerical character, stop checking the string
                    notValidCapacity = true;
                    break;
                }
            }
            //if the capacity entered by the user does not contain only numerical characters, display "error" message and re-prompt via do-while loop
            if (notValidCapacity) {
                System.out.println("Please enter a valid size.");
            }
        } while (notValidCapacity);
        System.out.println("The Pakudex can hold " + capacityNumber + " species of Pakuri.\n");
        //Pakudex capacity set to the integer the user typed in via Integer.parseInt()
        Pakudex newPakudex = new Pakudex(Integer.parseInt(capacityNumber));
        while (isLooping) {
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit\n");
            System.out.print("What would you like to do? ");
            //menuSelection initialized as string so that any invalid inputs that involve non-numerical characters will display an "invalid input" message
            menuSelection = scnr.next();
            if (Objects.equals(menuSelection, "1")) {
                //boolean to check if no Pakuri have been added to the Pakudex yet
                boolean noPakuri = false;
                //if the species array is empty, no Pakuri have been added to the Pakudex yet
                    if (Objects.equals(newPakudex.getSpeciesArray(), null)) {
                        noPakuri = true;
                    }
                if (noPakuri) {
                    System.out.println("No Pakuri in Pakudex yet!\n");
                } else {
                    System.out.println("Pakuri In Pakudex:");
                    //gets names of Pakuri currently in Pakudex
                    String[] speciesArray = newPakudex.getSpeciesArray();
                    for (int i = 0; i < speciesArray.length; i++) {
                        //returns list of Pakuri in Pakudex in the order they are in the species array at the moment
                        System.out.println((i + 1) + ". " + speciesArray[i]);
                    }
                    System.out.print("\n");
                }
            } else if (Objects.equals(menuSelection, "2")) {
                System.out.print("Enter the name of the species to display: ");
                pakuriName = scnr.next();
                //boolean to check if the entered species name exists as a species name in the Pakudex
                boolean isInPakudex = false;
                //for loop iterating through the Pakudex, checks if any species name currently in the Pakudex is equal to the user's entered name
                for (int i = 0; i < newPakudex.getSize(); i++) {
                    //if a species name currently in the Pakudex is equal to the user's entered name
                    if (Objects.equals(newPakudex.getSpeciesArray()[i], pakuriName)) {
                        isInPakudex = true;
                    }
                }
                if (isInPakudex) {
                    //prints out species with its name along with its statistics
                    System.out.println("Species: " + pakuriName);
                    //getStats() called to grab the statistics of the user's entered Pakuri
                    int[] statsArray = newPakudex.getStats(pakuriName);
                    System.out.println("Attack: " + statsArray[0]);
                    System.out.println("Defense: " + statsArray[1]);
                    System.out.println("Speed: " + statsArray[2]);
                    System.out.print("\n");
                } else {
                    //if species does not exist in the Pakudex, return "error" message
                    System.out.println("Error: No such Pakuri!\n");
                }
            } else if (Objects.equals(menuSelection, "3")) {
                //boolean to check if the Pakudex has reached its maximum capacity
                boolean isFull = true;
                //if the current amount of Pakuri in the Pakudex is not 0 and the amount of Pakuri in the Pakudex is equal to its maximum capacity
                if (newPakudex.getSize() != 0 && (newPakudex.getSize() == newPakudex.getCapacity())) {
                    isFull = true;
                } else {
                    isFull = false;
                }
                if (isFull) {
                    //displays "error" message if the Pakudex is full and sends user back to menu options
                    System.out.println("Error: Pakudex is full!\n");
                    continue;
                }
                System.out.print("Enter the name of the species to add: ");
                pakuriName = scnr.next();
                //addPakuri() called to add the species (along with corresponding statistics) to the Pakudex
                newPakudex.addPakuri(pakuriName);
            } else if (Objects.equals(menuSelection, "4")) {
                System.out.print("Enter the name of the species to evolve: ");
                pakuriName = scnr.next();
                //if the entered name is the same as the name of a Pakuri currently in the Pakudex, the Pakuri is evolved
                if (newPakudex.evolveSpecies(pakuriName)) {
                    System.out.println(pakuriName + " has evolved!\n");
                } else {
                    System.out.println("Error: No such Pakuri!\n");
                }
            } else if (Objects.equals(menuSelection, "5")) {
                //sortPakuri() called to sort the list of Pakuri in the Pakudex (which can be displayed using menu option 1)
                newPakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!\n");
            } else if (Objects.equals(menuSelection, "6")) {
                System.out.println("Thanks for using Pakudex! Bye!");
                //sets isLooping to false to stop prompting the user and end the program
                isLooping = false;
            } else {
                //if the inputted menu option is not an integer between 1-6, return an "invalid input" message
                System.out.println("Unrecognized menu selection!\n");
            }
        }
    }
}
