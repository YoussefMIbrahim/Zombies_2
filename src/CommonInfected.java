public class CommonInfected extends Zombie {

    private static int counter = 0;
    private int id;

    public CommonInfected(){

        super(30,5);

        this.id = ++counter;
    }

    @Override
    public int getId(){return this.id;}

}
