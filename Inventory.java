public class Inventory
{
    private Weapon weapon;
    private Armor armor;
    private boolean food, water, wood;

    public Inventory()
    {
        this.weapon = new Weapon("Fist", 0,0, 0);
        this.armor = new Armor(0, "Broken Armor", 0, 0);
    }
    public Weapon getWeapon()
    {
        return weapon;
    }
    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }
    public Armor getArmor()
    {
        return armor;
    }
    public void setArmor(Armor armor)
    {
        this.armor = armor;
    }
    public boolean getFood()
    {
        return food;
    }
    public void setFood(boolean food)
    {
        this.food = food;
    }
    public boolean getWater() {
        return water;
    }
    public void setWater(boolean water)
    {
        this.water = water;
    }
    public boolean getWood()
    {
        return wood;
    }
    public void setWood(boolean wood)
    {
        this.wood = wood;
    }
}