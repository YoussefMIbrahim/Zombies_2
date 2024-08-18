public class Soldier extends Survivor {

    //Keeps track of soldier instances
    private static int counter = 0;

    // Unique ID
    private int id;

    //Constructor
    public Soldier() {
        this.id = ++counter;
    }

    //Getting Soldier ID
    //Retruns ID
    public int getId() {
        return id;
    }
}