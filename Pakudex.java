//java.util.Arrays imported for sorting the array of Pakuri(s)
import java.util.Arrays;
//java.util.Objects imported for Object.equals()
import java.util.Objects;

public class Pakudex {
    private int capacity;
    private Pakuri[] speciesArray;
    //default constructor if the capacity is never valid
    public Pakudex() {
        this.capacity = 20;
        speciesArray = new Pakuri[20];
    }
    public Pakudex (int capacity) {
        //sets capacity of the Pakudex to the value entered by the user
        this.capacity = capacity;
        //also creates an array of Pakuri the same size as the value entered by the user
        speciesArray = new Pakuri[capacity];
    }
    public int getSize() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            //if the capacity of the Pakudex is 1
            if (capacity == 1) {
                //if there's no Pakuri at the first index of the 1-capacity Pakudex
                if (Objects.equals(speciesArray[0], null)) {
                    size = 0;
                    break;
                } else {
                    size = 1;
                    break;
                }
            }
            //if there's no Pakuri at the checked index of the Pakudex
            if (Objects.equals(speciesArray[i], null)) {
                //stores the amount of Pakuri currently in the Pakudex in the size variable
                size = i;
                break;
            } else {
                //if speciesArray has no empty indexes, the size is equal to speciesArray.length (the maximum capacity)
                size = speciesArray.length;
            }
        }
        //returns the amount of Pakuri currently in the Pakudex
        return size;
    }
    public int getCapacity() {
        //returns the maximum capacity of the Pakudex
        return this.capacity;
    }
    public String[] getSpeciesArray() {
        //if there are no Pakuri in the Pakudex, return nothing
        if (getSize() == 0) {
            return null;
        }
        //create a new string array the same size as the amount of Pakuri currently in the Pakudex
        String[] nameArray = new String[getSize()];
        for (int i = 0; i < getSize(); i++) {
            //set the species name stored in nameArray at the current index to the corresponding species name in speciesArray at that same index
            nameArray[i] = speciesArray[i].getSpecies();
        }
        return nameArray;
    }
    public int[] getStats (String species) {
        //create a new integer array to store the statistics of the entered species name
        int[] statsArray = new int[3];
        for (int i = 0; i < speciesArray.length; i++) {
            //if the current index in speciesArray is empty, skip to the next index
            if (speciesArray[i] == null) {
                continue;
            }
            //if the name of the Pakuri in speciesArray is the same as the user's entered name
            if (Objects.equals(speciesArray[i].getSpecies(), species)) {
                //calls getAttack(), getDefense(), and getSpeed() and stores them in statsArray
                statsArray[0] = speciesArray[i].getAttack();
                statsArray[1] = speciesArray[i].getDefense();
                statsArray[2] = speciesArray[i].getSpeed();
                //returns the statistics stored in the array
                return statsArray;
            }
        }
        //if all the indexes in speciesArray are empty, return nothing
        return null;
    }
    public void sortPakuri() {
        String[] nameArray = getSpeciesArray();
        //if there are species currently in the Pakudex
        if (nameArray != null) {
            //Arrays.sort to sort the list of species names in the Pakudex
            Arrays.sort(nameArray);
            for (int i = 0; i < nameArray.length; i++) {
                for (int j = 0; j < getSize(); j++) {
                    //if the amount of Pakuri currently in the Pakudex is not 1
                    if (!(nameArray.length == 1 || getSize() == 1)) {
                        //if the current index in speciesArray contains nothing, go to the next index
                        if (speciesArray[j] == null) {
                            continue;
                        }
                        if (speciesArray[j] != null) {
                            //if the species name at the current index in speciesArray is the same as the name at an index in nameArray
                            if (Objects.equals(speciesArray[j].getSpecies(), nameArray[i])) {
                                //"swaps" the 2 places of the species names using 2 placeholder variables
                                Pakuri placeholder = speciesArray[j], placeholder2 = speciesArray[i];
                                speciesArray[i] = placeholder;
                                speciesArray[j] = placeholder2;
                            }
                        }
                    } else {
                        //if the amount of Pakuri currently in the Pakudex is 1, the list doesn't need to be sorted
                        break;
                    }
                }
            }
        }
    }
    public boolean addPakuri (String species) {
            for (int j = 0; j < capacity; j++) {
                //if the current index in speciesArray is empty
                if (Objects.equals(speciesArray[j], null)){
                    //generates new Pakuri with the entered species name at the current index
                    speciesArray[j] = new Pakuri(species);
                    System.out.println("Pakuri species " + species + " successfully added!\n");
                    return true;
                //if the Pakudex (speciesArray) already contains a species with the entered species name, display an "error" message
                } else if (Objects.equals(speciesArray[j].getSpecies(), species)) {
                    System.out.println("Error: Pakudex already contains this species!\n");
                    return false;
                }
            }
            return false;
    }
    public boolean evolveSpecies (String species) {
        for (int i = 0; i < speciesArray.length; i++) {
            //if the current index in speciesArray is empty, skip to the next index
            if (speciesArray[i] == null) {
                continue;
            }
            if (Objects.equals(speciesArray[i].getSpecies(), species)) {
                //calls evolve() to set the new statistics of the Pakuri at the current index
                speciesArray[i].evolve();
                return true;
            }
        }
        return false;
    }
}
