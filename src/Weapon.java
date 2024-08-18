import java.util.Random;

//accuracy, name and damage of weapon
public class Weapon {
    private String name;
    private int damage;
    private double accuracy;

    //Constructor for weapon
    public Weapon(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    //Damage with chosen weapon
    public int getDamage() {
        return damage;
    }

    //If weapon will hit accurately
    public boolean isHit() {
        Random random = new Random();
        return random.nextDouble() <= accuracy;
    }

    //Returns weapons name used
    @Override
    public String toString() {
        return name;
    }
}