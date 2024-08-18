public class Tank extends Zombie {

    // Constructor starting at 100 health
    public Tank() {
        super(100);
    }

    //Tanks attack 30 damage
    @Override
    public int attack() {
        return 30;
    }
}