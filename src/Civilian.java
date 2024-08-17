public class Civilian extends Survivor{

    private static int counter = 0;
    private int id;

    public Civilian(){

        super(50,5);
        this.id = ++counter;

    }

    @Override
    public int getId(){return this.id;}

    
}
