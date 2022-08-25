public class MarketPlace extends NormalLoc
{
    public MarketPlace(Player player)
    {
        super(player, "Market");
    }
    public boolean onLocation()
    {
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the Market !");
        System.out.println("--------------------------------------");
        System.out.println("1 - Weapons \n2 - Armor\n3 - Quit");
        System.out.print("Please choose one of them: ");
        switch (scan.nextInt()) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Quiting...");
                return true;
            default:
                printWeapon();
                buyWeapon();
                break;
        }
        return true;
    }
    public void printWeapon()
    {
        System.out.println("--------------------------------------");
        System.out.println("WEAPONS");
        for (Weapon w : Weapon.weapons())
        {
            System.out.println(w.getID() + " - " +w.getName() + " < Price: " + w.getPrice() + ", Damage: " + w.getDamage() + " >");   
        }
    }
    public void buyWeapon()
    {
        System.out.print("Please choose a weapon: ");
        
        int choosenWeapon = scan.nextInt();

        while (choosenWeapon < 1 || choosenWeapon > Weapon.weapons().length)
        {
            System.out.print("Invalid Input ! Try again:");
            choosenWeapon = scan.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponByID(choosenWeapon);
        
        if(selectedWeapon != null)
        {
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney())
            {
                System.out.println("You don't have enough money !!!");
            }
            else
            {
                System.out.println("You new weapon is a " + selectedWeapon.getName());
                int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Remaining money: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("--------------------------------------");
            }
        }
    }
    public void printArmor()
    {
        System.out.println("--------------------------------------");
        System.out.println("ARMOR");
        for (Armor a : Armor.armors())
        {
            System.out.println(a.getID() + " - " +a.getName() + " < Price: " + a.getPrice() + ", Blocking: " + a.getBlock() + " >");   
        }
    }
    public void buyArmor()
    {
        System.out.print("Please choose a armor: ");
        
        int choosenArmor = scan.nextInt();

        while (choosenArmor < 1 || choosenArmor > Armor.armors().length)
        {
            System.out.print("Invalid Input ! Try again:");
            choosenArmor = scan.nextInt();
        }

        Armor selectedArmor = Armor.getArmorByID(choosenArmor);
        
        if(selectedArmor != null)
        {
            if(selectedArmor.getPrice() > this.getPlayer().getMoney())
            {
                System.out.println("You don't have enough money !!!");
            }
            else
            {
                System.out.println("You new armor is a " + selectedArmor.getName());
                int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Remaining money: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("--------------------------------------");
            }
        }
    } 
}