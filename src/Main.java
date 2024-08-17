import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Release 2.0's sample run:");

        // calling the generate Objects method to generate a list of zombies or survivors depending on the information we pass through
        List<Zombie> zombieList = new ArrayList<>();
        zombieList = generateZombies(8);

        List<Survivor> survivorList = new ArrayList<>();
        survivorList = generateSurvivors(9);

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
    public static List<Zombie> generateZombies(int count){

        // creating a new random object for list generation
        Random random = new Random();

        List<Zombie> zombies = new ArrayList<>();

        // generating zombies using random, if it's 0 we get common and 1 is tank

            for (int i = 0; i < count; i++){

                // generating a number between 0 and 1
                int num = random.nextInt(2);

                switch (num) {

                    case 0 -> zombies.add(new CommonInfected());
                    case 1 -> zombies.add(new Tank());
                }
            }
        return zombies;
        }



    public static List<Survivor> generateSurvivors(int count){

        Random random = new Random();

        List<Survivor> survivors = new ArrayList<>();

        for (int i = 0; i < count; i++){

            // generating a random number between 0 and 3 to generate a random survivor
            int num = random.nextInt(3);

            // generating survivors depending on the number from random
            switch (num) {

                case 0 -> survivors.add(new Civilian());
                case 1 -> survivors.add(new Soldier());
                case 2 -> survivors.add(new Scientist());
            }
        }

            return survivors;
        }



    //Starting the Zombie War
    public static void ZombieWar(List < Survivor > survivors, List < Zombie > zombies) {


        //While loop to keep the game going until one side is empty
        while (!survivors.isEmpty() && !zombies.isEmpty()) {

            
            Iterator<Zombie> zombieIterator = zombies.iterator();

            while(zombieIterator.hasNext()) {
                
                Zombie zombie = zombieIterator.next();
            
                for (Survivor survivor: survivors) {

                    if(zombies.isEmpty()){
                        break;
                    }

                    int survivorAttack = survivor.attack();

                    zombie.hit(survivorAttack);

                    if(zombie.dead()){

                        System.out.printf("%s %d Killed %s %d\n", survivor, survivor.getId(),zombie,zombie.getId());
                        zombieIterator.remove();
                        break;
                        
                    }
                }
            }

            Iterator<Survivor> survivorIterator = survivors.iterator();

            while(survivorIterator.hasNext()) {
                
                Survivor survivor = survivorIterator.next();
            
                for (Zombie zombie: zombies) {

                    if(survivors.isEmpty()){
                        break;
                    }

                    int zombieAttack = zombie.attack();

                    survivor.hit(zombieAttack);

                    if(survivor.dead()){

                        System.out.printf("%s %d Killed %s %d\n", survivor, survivor.getId(),zombie,zombie.getId());
                        survivorIterator.remove();
                        break;
                        
                    }
                }
            }
   
        }    
    }
}
