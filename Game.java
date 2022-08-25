import java.util.Scanner;

public class Game
{
    Scanner scan = new Scanner(System.in);

    public void start()
    {
        System.out.println("Welcome to the Adventure Game !");
        System.out.print("Please type your name adventurer: ");
        Player player = new Player(scan.nextLine());
        System.out.println(player.getName() + " welcome to this dark and foggy island !");
        player.selectCharacter();

        Location location = null;

        while(true)
        {
            player.printInfo();
            System.out.print("Locations: \n1 - Safe House --> For Healing ! (No Enemy) \n2 - Market --> You can buy weapons and armor !\n3 - Cave --> Enter the dark cave and fight against zombies! \n4 - Forest --> Enter the dangerous forest and fight against Vampire! \n5 - River --> Enter the damp river and fight against big Bears! \n5 - Quarry --> Enter the quarry and fight against snakes! \nPlease enter the location you want to go: ");

            switch (scan.nextInt())
            {
            case 1:
                location = new SafeHouse(player);
                System.out.println("--------------------------------------");
                break;
            case 2:
                location = new MarketPlace(player);
                System.out.println("--------------------------------------");
                break;
            case 3:
                if(!player.getInventory().getFood())
                {
                    location = new Cave(player);
                    System.out.println("--------------------------------------");
                }
                else
                {
                    System.out.println("--------------------------------------");
                    System.out.println("You already complete this area!");
                    System.out.println("--------------------------------------");
                }
                break;
            case 4:
                if(!player.getInventory().getWood())
                {
                location = new Forest(player);
                System.out.println("--------------------------------------");
                }
                else
                {
                    System.out.println("--------------------------------------");
                    System.out.println("You already complete this area!");
                    System.out.println("--------------------------------------");
                }
                break;
            case 5:
                if(!player.getInventory().getWater())
                {
                location = new River(player);
                System.out.println("--------------------------------------");
                }
                else
                {
                    System.out.println("--------------------------------------");
                    System.out.println("You already complete this area!");
                    System.out.println("--------------------------------------");
                }
                break;
            case 6:
                location = new Quarry(player);
                System.out.println("--------------------------------------");
                break;
            default:
                location = new SafeHouse(player);
                System.out.println("--------------------------------------");
                break;
            }

            if(! location.onLocation())
            {
                System.out.println("GAME OVER !!! \nIt was a good adventure...");
                break;
            }
        }
    }
}