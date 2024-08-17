public class Scientist extends Survivor{

    private static int counter = 0;
    private int id;

    public Scientist(){
        super(20,2);
        this.id = ++counter;
    }
}
