public class SafeHouse extends NormalLoc
{
    public SafeHouse(Player player)
    {
        super(player, "Safe House");
    }

    public boolean onLocation()
    {
        System.out.println("--------------------------------------");
        System.out.println("You're on Safe House now !");
        System.out.println("Your health has been renewed !");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("--------------------------------------");
        if(getPlayer().getInventory().getFood() && getPlayer().getInventory().getWood() && getPlayer().getInventory().getWater())
        {
            System.out.println("YOU WON THE GAME !!! \nWELL DONE ADVENTURER!!!");
            System.exit(0);
        }
        return true;
    }
}