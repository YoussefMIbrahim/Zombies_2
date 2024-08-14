/*
CSC 422 - Software Engineering
Zombie War Project
*/

public class Zombie extends Character {

/*Sets the "Type" of Zombie*/
    static final String COMMON_INFECTED = "CommonInfected";
    static final String TANK = "Tank";

    private final String zombieType;

    public Zombie(String zombieType, int health, int attack) {
        super(Character.Zombie, health, attack);
        this.zombieType = zombieType;
}

    @Override
    public String toString() {
        return zombieType;
    }
}