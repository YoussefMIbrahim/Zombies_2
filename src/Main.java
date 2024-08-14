import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        // calling the generate Objects method to generate a list of zombies or survivors depending on the information we pass through
        List<Object> zombieList = new ArrayList<>();
        zombieList = generateObjects(5,"Zombies");

        List<Object> survivorList = new ArrayList<>();
        survivorList = generateObjects(5,"Survivors");

        // randomly generated lists of zombies and survivors, currently just printing them out to make sure they are getting generated correctly.
        System.out.println(zombieList);
        System.out.println(survivorList);
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


}
