import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Release 1.0's sample run:");

        // calling the generate Objects method to generate a list of zombies or survivors depending on the information we pass through
        List<Object> zombieList = new ArrayList<>();
        zombieList = generateObjects(8,"Zombies");

        List<Object> survivorList = new ArrayList<>();
        survivorList = generateObjects(17,"Survivors");

        // randomly generated lists of zombies and survivors, currently just printing them out to make sure they are getting generated correctly.
        System.out.println("We have " + survivorList.size() + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombieList.size() + " zombies waiting for them.");

        ZombieWar(survivorList, zombieList);

        if(survivorList.size() > 0){
            System.out.println("It seems " + survivorList.size() + " have made it to safety.");
        } else {
            System.out.println("It seems all survivors have been killed.");
        }
    }

    // Generate the list of either zombies or survivors
    public static List<Object> generateObjects(int count, String type){

        // creating a new random object for list generation
        Random random = new Random();

        List<Object> characters = new ArrayList<>();

        // generating zombies using random, if it's 0 we get common and 1 is tank
        if(type.equals("Zombies")){

            for (int i = 0; i < count; i++){

                // generating a number between 0 and 1
                int num = random.nextInt(2);

                switch (num) {

                    case 0 -> characters.add(new CommonInfected());
                    case 1 -> characters.add(new Tank());
                }
            }
            return characters;

        }else{

            for (int i = 0; i < count; i++){

                // generating a random number between 0 and 3 to generate a random survivor
                int num = random.nextInt(3);

                // generating survivors depending on the number from random
                switch (num) {

                    case 0 -> characters.add(new Civilian());
                    case 1 -> characters.add(new Soldier());
                    case 2 -> characters.add(new Scientist());
                }
            }

            return characters;
        }

    }


    //Starting the Zombie War
    public static void ZombieWar(List < Object > survivors, List < Object > zombies) {

        //creating a new random object for selecting a random survivor or zombie
        Random random = new Random();

        //While loop to keep the game going until one side is empty
        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            //Generatates a random number between 0 and the size of the list

            int survivorIndex = random.nextInt(survivors.size());
            Object survivor = survivors.get(survivorIndex);

            int zombieIndex = random.nextInt(zombies.size());
            Object zombie = zombies.get(zombieIndex);

            //Survivor attacks the zombie
            int survivorAttack = ((Survivor) survivor).attack();

            //Zombie attacks the suvivor
            int zombieAttack = ((Zombie) zombie).attack();

            //Takes damage lose health
            ((Zombie) zombie).hit(survivorAttack);

            ((Survivor) survivor).hit(zombieAttack);

            //If the zombie is dead it is removed from the list
            if (((Zombie) zombie).dead()) {
                zombies.remove(zombie);
            }

            //If the Survivor is dead it is removed from the list
            if (((Survivor) survivor).dead()) {
                survivors.remove(survivor);
            }    
        }    
    }
}
