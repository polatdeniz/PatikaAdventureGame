public class Armor
{
    private int ID;
    private String name;
    private int block;
    private int price;

    public static Armor[] armors()
    {
        Armor [] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Ligth", 1, 15);
        armorList[1] = new Armor(2, "Medium", 3, 25);
        armorList[2] = new Armor(3, "Heavy", 5, 45);

        return armorList;
    }
    public Armor(int iD, String name, int block, int price)
    {
        ID = iD;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public int getID()
    {
        return ID;
    }
    public void setID(int iD)
    {
        ID = iD;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getBlock()
    {
        return block;
    }
    public void setBlock(int block)
    {
        this.block = block;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public static Armor getArmorByID(int ID)
    {
        for(Armor a : Armor.armors())
        {
            if(a.getID() == ID)
            {
                return a;
            }
        }
        return null;
    }
}
