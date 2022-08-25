import java.util.Scanner;

public class Player
{
    Scanner scan = new Scanner(System.in);

    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String character;
    private String name;
    private int originalHealth;

    public int getTotalDamage()
    {
        return (getDamage()+ this.getInventory().getWeapon().getDamage());
    }
    public void printInfo()
    {
        System.out.println("--------------------------------------");
        System.out.println(
            "Your weapon: " + this.getInventory().getWeapon().getName() + 
            "\nYour Armor:  " + this.getInventory().getArmor().getName() + 
            "\nYour total damage: " + this.getTotalDamage() + 
            "\nYour total block value: "+ this.getInventory().getArmor().getBlock() + 
            "\nYour Health: " + this.getHealth() + 
            "\nMoney: " + this.getMoney());
        System.out.println("--------------------------------------");
    }
    public Player(String name)
    {
        this.name = name;
        this.inventory = new Inventory();
    }
    public Inventory getInventory()
    {
        return inventory;
    }
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }
    public int getDamage()
    {
        return damage;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public String getCharacter()
    {
        return character;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void selectCharacter()
    {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("--------------------------------------");
        for (GameChar gameChar : charList)
        {
            System.out.println("ID: " + gameChar.getID() + " \t Character: " + gameChar.getName() + " \t Damage: " + gameChar.getDamage() + " \t Health: " + gameChar.getHealth() + " \t Money: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------");
        System.out.print("Please choose one of them: ");

        switch (scan.nextInt())
        {
            case 1:
                initPlayer(charList[0]);
                break;
            case 2:
                initPlayer(charList[1]);
                break;
            case 3:
                initPlayer(charList[2]);
                break;
            default:
                System.out.println("Invalid ID! \nPlease try again!");
                selectCharacter();
                break;
        }
    }
    public void initPlayer(GameChar gameChar)
    {
        System.out.println("Your choice is " + gameChar.getName());
        System.out.println("--------------------------------------");
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
        this.originalHealth = gameChar.getHealth();
    }
    public int getOriginalHealth()
    {
        return originalHealth;
    }
}