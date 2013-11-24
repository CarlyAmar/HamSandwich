package mob;
public class Mob
{
    private int maxHealth;
    private int maxMagic;
    private int maxStamina;
    
    private int currentHealth;
    private int currentMagic;
    private int currentStamina;
    
    private int strength;
    private int magic;
    
    public Mob(int newMaxHealth, int newMagic, int newStamina, int newStrength)
    {
        maxHealth = newMaxHealth;
        maxMagic = newMagic;
        maxStamina = newStamina;
        
        strength = newStrength;
        magic = newMagic;
    }
    
    public int getCurrentHealth()
    {
        return currentHealth;
    }
    public int getMagic()
    {
        return currentMagic;
    }
    public void setCurrentHealth(int h)
    {
        currentHealth = h;
    }
     
     
     
     
     
    public int attack ()
    {
        return 1; 
    }
     
}