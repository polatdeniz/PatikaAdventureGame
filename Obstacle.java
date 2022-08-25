public class Obstacle
{
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int bounty;
    private int defHealth;

    public Obstacle(int ID, String name, int damage, int health, int bounty)
    {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.bounty = bounty;
        this.defHealth = health;
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
        if(health < 0)
        {
            health = 0;
        }
        this.health = health;
    }    
    public int getBounty()
    {
        return bounty;
    }
    public void setBounty(int bounty)
    {
        this.bounty = bounty;
    }
    public int getDefHealth()
    {
        return defHealth;
    }
    public void setDefHealth(int defHealth)
    {
        this.defHealth = defHealth;
    }
   }