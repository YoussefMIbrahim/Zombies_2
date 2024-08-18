public class Civilian extends Survivor {

    //Keeps track of Civilian instances
    private static int counter = 0;

    //Unique ID
    private int id;

    //Getting Civilian ID
    //Retruns ID
    public Civilian() {
        this.id = ++counter;

    }

}