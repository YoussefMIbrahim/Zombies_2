//Id generation for zombies and health values
public abstract class Zombie {
  private int id;
  private static int idCounter = 1;
  private int health;

  //Constructor to set heatlh of zombie
  public Zombie(int health) {
    this.id = idCounter++;
    this.health = health;
  }

  //Zombie attack
  public abstract int attack();

  //Apply damage and subtract damage from health
  public void hit(int damage) {
    this.health -= damage;
  }

  //Checking to see if Zombie is dead
  public boolean dead() {
    return health <= 0;
  }

  //Getting zombie ID
  public int getId() {
    return id;
  }
}