/*
CSC 422 - Software Engineering
Zombie War Project
*/
public class ZombieWar {

        public static void main(String[] args) {

        System.out.println("Hello GITHUB");
    }

    //Zombie.java

   }
}


//Zombie Class
public class Zombie extends Character {

// Zombie types
    static final String COMMON_INFECTED = "CommonInfected";
    static final String TANK = "Tank";

    private final String zombieType;

    public Zombie(String zombieType, int health, int attack) {
        super(Character.Zombie, health, attack);

// sets zombie type
        this.zombieType = zombieType;
}

    @Override
    public String toString() {
        return zombieType;
    }
}


//Tank Class
public class Tank extends Zombie {

    private static final int HEALTH = 100;
    private static final int ATTACK = 10;


    public Tank() {
        super(Zombie.TANK, HEALTH, ATTACK);
    }
}

}
