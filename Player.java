package org.hamsandwich;

public class Player 
{
	private String name;
    private int level;
    
    private int maxHealth;
    private int maxMagic;
    private int maxStamina;
    
    private int currentHealth;
    private int currentMagic;
    private int currentStamina;

    private int archery;
    private int melee;
    private int sneak;
    
    private int defense;
    
    public int getLevel()
    {
        return this.level;
    }

    public Player(int newMaxHealth, int newMaxMagic, int newMaxStamina)
    {
        maxHealth = newMaxHealth;
        maxMagic = newMaxMagic;
        maxStamina = newMaxStamina;
    }
                            //getters
    public int getCurrentHealth()
    {
        return this.currentHealth; //problem with this
    }
    public int getMaxHealth()
    {
        return this.maxHealth;
    }
    public int getCurrentMagic()
    {
        return this.currentMagic;
    }
    public int getMaxMagic()
    {
        return this.maxMagic;
    }
    public int getCurrentStamina()
    {
        return this.currentStamina;
    }
    public int getMaxStamina()
    {
        return this.maxStamina;
    }
    
    
    public int getArchery()
    {
        return this.archery;
    }
    public int getMelee()
    {
        return this.melee;
    }
    public int getSneak()
    {
        return this.sneak;
    }
    
    
                        //setters
    public void setName(String newName)
    {
        this.name = newName;
    }
    public void setMaxHealth(int newMaxHealth)
    {
        this.maxHealth = newMaxHealth;
    }
    public void setCurrentHealth(int newCurrentHealth)
    {
        this.currentHealth = newCurrentHealth;
    }
    public void setMaxMagic(int newMaxMagic)
    {
        this.maxMagic = newMaxMagic;
    }
    public void setCurrentMagic(int newCurrentMagic)
    {
        this.currentMagic = newCurrentMagic;
    }
    public void setMaxStamina(int newMaxStamina)
    {
        this.maxStamina = newMaxStamina;
    }
    
    
    public void setMaxArchery(int newMaxArchery)
    {
        this.archery = newMaxArchery;
    }
    public void setMaxMelee(int newMaxMelee)
    {
        this.melee = newMaxMelee;
    }
    public void setMaxSneak(int newMaxSneak)
    {
        this.sneak = newMaxSneak;
    }
    /*
    public boolean comeAtMeBro (Mob other)//Make sure to correct this when we implement Mobs
    {
        while (true)
        {
            if (currentHealth <= 0)
            {
                System.out.println("You have died\nRestart? [y]/[n]");
                return false;
            }
            else if (other.getCurrentHealth() <= 0)
                return true;
            else 
            {
                other.setCurrentHealth(attack(other));
                defend(other);
            }
        }
    }
    private int attack(Mob other)
    {
        if (((this.melee*currentStamina) * (Math.random() * 100)) - (other.defense()) > 0)
        {
            return (((this.melee*currentStamina) * (Math.random() * 100)) - (other.defense()));
        }
        else 
            return 0;
    }
    private void defend(Mob other)
    {
        if ((other.attack()) - (this.melee * Math.random() * 100) > 0)
        {
            this.currentHealth = other.attack() - (this.defense );//Enter a defense formula here
        }
        else
            System.out.println("You block his attack");
    }
    */

}
