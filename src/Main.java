import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Release 3.0's sample run:");

        Random random = new Random();

        //calling the generate Objects method to generate a list of zombies or survivors depending on the information we pass through
        List < Zombie > zombieList = generateZombies(random.nextInt(9) + 1);
        List < Survivor > survivorList = generateSurvivors(random.nextInt(9) + 1);

        int[] survivorCount = survivorCount(survivorList);
        int[] zombieCount = zombieCount(zombieList);

        //randomly generated lists of zombies and survivors, currently just printing them out to make sure they are getting generated correctly.
        System.out.println("We have " + survivorList.size() + " survivors trying to make it to safety. (" +
            survivorCount[0] + " scientist, " + survivorCount[1] + " civilian, " +
            survivorCount[2] + " soldiers)");
        System.out.println("But there are " + zombieList.size() + " zombies waiting for them. (" +
            zombieCount[0] + " common infected, " + zombieCount[1] + " Tanks)");

        //Begin zombie war
        ZombieWar(survivorList, zombieList);

        //Print out the final state of the zombie war
        if (survivorList.size() > 0) {
            System.out.println("It seems " + survivorList.size() + " have made it to safety.");
        } else {
            System.out.println("It seems all survivors have been killed.");
        }
    }

    // Generate the list of either zombies or survivors
    public static List < Zombie > generateZombies(int count) {
        Random random = new Random();
        List < Zombie > zombies = new ArrayList < > ();

        for (int i = 0; i < count; i++) {
            int num = random.nextInt(2);

            switch (num) {
            case 0 -> zombies.add(new CommonInfected());
            case 1 -> zombies.add(new Tank());
            }
        }
        return zombies;
    }

    public static List < Survivor > generateSurvivors(int count) {
        
        Random random = new Random();
        
        List < Survivor > survivors = new ArrayList < > ();

        for (int i = 1; i < count; i++) {

            //generating a random number between 0 and 3 to generate a random survivor
            int num = random.nextInt(3);

            //generating survivors depending on the number from random
            switch (num) {
            case 0 -> survivors.add(new Civilian());
            case 1 -> survivors.add(new Soldier());
            case 2 -> survivors.add(new Scientist());
            }
        }
        return survivors;
    }

    //Starting the zombie war
    public static void ZombieWar(List < Survivor > survivors, List < Zombie > zombies) {
        
        ////While loop to keep the game going until one side is empty
        while (!survivors.isEmpty() && !zombies.isEmpty()) {
            
            //Making an iterator for use with the zombie list, so that the zombie can be deleted safely
            Iterator < Zombie > zombieIterator = zombies.iterator();

            while (zombieIterator.hasNext()) {
                Zombie zombie = zombieIterator.next();

                ////Inner loop to make every survivor attack one specific zombie
                for (Survivor survivor: survivors) {
                    int survivorAttack = survivor.attack();

                    if (survivorAttack > 0) {
                        zombie.hit(survivorAttack);

                        // //Checking if the zombie died and removing it from the list
                        if (zombie.dead()) {
                            System.out.printf("%s %d killed %s %d with %s\n",
                                survivor.getClass().getSimpleName(), survivor.getId(),
                                zombie.getClass().getSimpleName(), zombie.getId(),
                                survivor.getWeapon());
                            zombieIterator.remove();
                            break;
                        }
                    } else {
                        System.out.printf("%s %d missed the shot with %s\n",
                            survivor.getClass().getSimpleName(), survivor.getId(),
                            survivor.getWeapon());
                    }
                }
            }
            
            //Making an iterator for use with the survivor list, so that the survivors can be deleted safely
            Iterator < Survivor > survivorIterator = survivors.iterator();

            while (survivorIterator.hasNext()) {
                Survivor survivor = survivorIterator.next();

                // Inner loop to make every zombie attack each individual survivor
                for (Zombie zombie: zombies) {
                    int zombieAttack = zombie.attack();
                    survivor.hit(zombieAttack);

                    //Checking if survivor is dead and removing them from the list
                    if (survivor.dead()) {
                        System.out.printf("%s %d killed %s %d\n",
                            zombie.getClass().getSimpleName(), zombie.getId(),
                            survivor.getClass().getSimpleName(), survivor.getId());
                        survivorIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    //These mthods check what kind of object is in these lists, and returns a count of each class.
    public static int[] survivorCount(List < Survivor > survivors) {
        int scientists = 0;
        int civilians = 0;
        int soldiers = 0;

        for (Survivor survivor: survivors) {
            if (survivor instanceof Soldier) {
                soldiers++;
            } else if (survivor instanceof Scientist) {
                scientists++;
            } else {
                civilians++;
            }
        }
        return new int[] {
            scientists,
            civilians,
            soldiers
        };
    }

    public static int[] zombieCount(List < Zombie > zombies) {
        int common = 0;
        int tanks = 0;

        for (Zombie zombie: zombies) {
            if (zombie instanceof Tank) {
                tanks++;
            } else {
                common++;
            }
        }
        return new int[] {
            common,
            tanks
        };
    }
}