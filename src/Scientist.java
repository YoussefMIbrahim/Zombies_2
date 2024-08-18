public class Scientist extends Survivor {

    //Keeps track of Scientist instances
    private static int counter = 0;

    //Unique ID
    private int id;

    //Getting Scientist ID
    //Retruns ID
    public Scientist() {
        this.id = ++counter;
    }
}