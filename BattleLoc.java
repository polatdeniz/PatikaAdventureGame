import java.util.Random;

public class BattleLoc extends Location
{
    Random random = new Random();
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle)
    {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }
    @Override
    public boolean onLocation() 
    {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You're currently here: " + this.getName());
        System.out.println("Be careful ! " + obsNumber + " " + getObstacle().getName() + " live here...");
        System.out.println("<F>igth! or <R>un Away!");
        String battleCase = scan.nextLine();

        if(battleCase.equalsIgnoreCase("F"))
        {
            System.out.println("You must be very brave !!! \nYour choice is FIGTH!!!");
            if(combat(obsNumber))
            {
                System.out.println(this.getName() + " beat all " + this.getObstacle().getName() + "s! \nWell Done!");
                if(this.award.equals("food") && getPlayer().getInventory().getFood() == false)
                {
                    System.out.println("You won the " + this.award);
                    getPlayer().getInventory().setFood(true);
                }
                else if(this.award.equals("wood") && getPlayer().getInventory().getWood() == false)
                {
                    System.out.println("You won the " + this.award);
                    getPlayer().getInventory().setWood(true);
                }
                else if(this.award.equals("water") && getPlayer().getInventory().getWater() == false)
                {
                    System.out.println("You won the " + this.award);
                    getPlayer().getInventory().setWater(true);
                }
                return true;
            }
        }
        if(this.getPlayer().getHealth() <= 0)
        {
            System.out.println("!!! You Died !!!");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber)
    {
        for (int i = 1; i <= obsNumber; i++)
        {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);

            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0)
            {
                System.out.println("<H>it or <R>un: ");
                String selectCombat = scan.nextLine();

                if(selectCombat.equalsIgnoreCase("H"))
                {
                    System.out.println("You hit the " + this.getObstacle().getName());
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0)
                    {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " hit you!!!");
                        int damageTaken = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(damageTaken < 0)
                        {
                            damageTaken = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - damageTaken);
                        afterHit();
                    }
                }
                else
                {
                    return false;
                }
            }

            if(this.getObstacle().getHealth() < this.getPlayer().getHealth())
            {
                if(this.getObstacle().getName().equalsIgnoreCase("snake"))
                {
                    System.out.println("--------------------------------------");
                    System.out.println("You Won the Fight !");
                    int randomLoot = random.nextInt(401);
                    if(randomLoot > 0 && randomLoot < 12)
                    {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(3));
                        System.out.println("You won Rifle");
                    }
                    else if (randomLoot > 12 && randomLoot < 30)
                    {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(2));
                        System.out.println("You won Sword");
                    }
                    else if(randomLoot > 30 && randomLoot < 60)
                    {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(1));
                        System.out.println("You won Handgun");
                    }
                    else if (randomLoot > 60 && randomLoot < 72)
                    {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorByID(3));
                        System.out.println("You won Heavy Armor");
                    }
                    else if (randomLoot > 72 && randomLoot < 90)
                    {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorByID(2));
                        System.out.println("You won Medium Armor");
                    }
                    else if(randomLoot > 90 && randomLoot < 120)
                    {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorByID(1));
                        System.out.println("You won Light Armor");
                    }
                    else if (randomLoot > 120 && randomLoot < 140)
                    {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                        System.out.println("You won Money");
                        System.out.println("Current money: " + this.getPlayer().getMoney());
                    }
                    else if(randomLoot > 140 && randomLoot < 170)
                    {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                        System.out.println("You won Money");
                        System.out.println("Current money: " + this.getPlayer().getMoney());
                    }
                    else if (randomLoot > 170 && randomLoot < 220)
                    {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                        System.out.println("You won Money");
                        System.out.println("Current money: " + this.getPlayer().getMoney());
                    }
                    else if (randomLoot > 220 && randomLoot < 400)
                    {
                        System.out.println("unlucky...");
                    }
                }
                else
                {
                System.out.println("--------------------------------------");
                System.out.println("You Won the Fight !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getBounty());
                System.out.println("Current money: " + this.getPlayer().getMoney());
                System.out.println("--------------------------------------");
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public void afterHit()
    {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health: " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats()
    {
        System.out.println("--------------------------------------");
        System.out.println("Player Stats:");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocked Damage: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("--------------------------------------");
    }
    public void obstacleStats(int i)
    {
        System.out.println("--------------------------------------");
        System.out.println(i + ". " +this.getObstacle().getName() +  " Stats:");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Bounty: " + this.getObstacle().getBounty());
        System.out.println("--------------------------------------");
    }
    public int randomObstacleNumber()
    {
        return (random.nextInt(this.getMaxObstacle()) + 1);
    }
    public int getMaxObstacle()
    {
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle)
    {
        this.maxObstacle = maxObstacle;
    }
    public Obstacle getObstacle()
    {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle)
    {
        this.obstacle = obstacle;
    }
    public String getAward()
    {
        return award;
    }
    public void setAward(String award)
    {
        this.award = award;
    }
}