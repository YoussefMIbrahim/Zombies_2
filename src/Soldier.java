public class Soldier extends Survivor {

    private static int counter = 0;
    private int id;

    public Soldier(){
        super(100,10);
        this.id = ++counter;
    }
    
    @Override
    public int getId(){return this.id;}

    
}
