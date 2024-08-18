import java.util.Random;

//Genertating random weapons for survivors using a unique id
//Also health value of the survivor
public abstract class Survivor {
    private Weapon weapon;
    private static final Random random = new Random();
    private int id;
    private static int idCounter = 1;
    private int health;

    //Constructor to initialize a survivor with random weapon
    //Setting intitial health
    public Survivor() {
        this.weapon = generateRandomWeapon();
        this.id = idCounter++;
        this.health = 100;
    }

    //Randomly assigning a weapon to the survivor
    private Weapon generateRandomWeapon() {

        //Weapons available
        Weapon[] weapons = {
            new Weapon("Shotgun", 30, 0.7),
            new Weapon("Submachine gun", 20, 0.6),
            new Weapon("Assault Rifle", 2, 0.8),
            new Weapon("Pistol", 20, 0.9),
            new Weapon("Axe", 15, 0.6),
            new Weapon("Crowbar", 15, 0.8),
            new Weapon("Frying Pan", 10, 0.9)
        };

        return weapons[random.nextInt(weapons.length)];
    }

    //Survivor attacks first
    public int attack() {
        //If the weapon hits the target it returns the damage
        //If it misses it returns 0
        if (weapon.isHit()) {
            return weapon.getDamage();
        } else {
            return 0;
        }
    }

    //Getting weapon
    public Weapon getWeapon() {
        return weapon;
    }

    //Getting ID
    public int getId() {
        return id;
    }

    //Survivor damage from Zombie
    public void hit(int damage) {
        this.health -= damage;
    }

    //Checking to see if survivor is dead
    public boolean dead() {
        return health <= 0;
    }
}