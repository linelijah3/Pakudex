public class Pakuri {
    private String species;
    private int attack;
    private int defense;
    private int speed;
    public Pakuri (String species) {
        //sets species name to entered species name
        this.species = species;
        //sets species statistics to values depending on the length of the species name
        this.attack = (this.species.length() * 7) + 9;
        this.defense = (this.species.length() * 5) + 17;
        this.speed = (this.species.length() * 6) + 13;
    }
    public String getSpecies() {
        //if the species name does not exist in the Pakudex, return nothing
        if (species == null) {
            return null;
        }
        //otherwise, return the name of the species
        return species;
    }
    //getAttack(), getDefense(), getSpeed() return the current attack, defense, or speed of the corresponding Pakuri species
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public int getSpeed() {
        return this.speed;
    }
    //setAttack() never used, but it would set the attack of a Pakuri species to a new value
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    public void evolve() {
        //multiplies the attack statistic of the Pakuri species by 2, the defense statistic by 4, and the speed statistic by 3
        this.attack *= 2;
        this.defense *= 4;
        this.speed *= 3;
    }
}
