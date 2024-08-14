public class Zombie {
    

    private int health;
    private int damage;

    public Zombie(int health, int damage){
        this.health = health;
        this.damage =damage;

    }

    public int attack(){
        return this.damage;
    }

    public void hit(int damageTaken){
        this.health -= damageTaken;
    }

    public boolean dead(){
        return this.health <=0;

    }

    public int getHealth(){return this.health;}

    public void setHealth(int health){this.health = health;}

    public int getDamage(){return this.damage;}

    public void setDamage(int damage){this.damage = damage;}
}
