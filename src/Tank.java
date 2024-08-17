public class Tank extends Zombie {
    
    private static int counter = 0;
    private int id;

    public Tank(){
        super(100,10);

        this.id = ++counter;
    }

    @Override
    public int getId(){return this.id;}

    @Override
    public String toString(){return "Tank";}
}
