public class CommonInfected extends Zombie {

    //Constructor starting at 30 health
    public CommonInfected() {
        super(30);
    }

    //CommonInfected attack 10 damage
    @Override
    public int attack() {
        return 10;
    }
}