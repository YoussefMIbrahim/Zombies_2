/*
CSC 422 - Software Engineering
Zombie War Project
*/
public class CommonInfected extends Zombie {

    private static final int HEALTH = 30;
    private static final int ATTACK = 5;


    public CommonInfected() {
        super(Zombie.COMMON_INFECTED, HEALTH, ATTACK);
    }
}
