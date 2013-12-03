package com.ham.gameobject;

import com.ham.gameobject.item.Item;

public class Stats 
{
	private float xp;
	private int health;
	private int level;
	private boolean levelable;
	public static final double LEVEL_CONST = Math.pow(3,(3.0/2.0));
	
	public Stats(float xp, boolean levelable)
	{
		this.levelable = levelable;
		
		if(levelable)
		{
			this.xp = xp;
			this.level = 1;
		}
		else
		{
			this.xp = -1;	
			this.level = (int)xp;
		}
		this.xp = xp;
		health = getMaxHealth();
	}
	public void addXp(float amt)
	{
		xp += amt;
	}

	/*
	@Override
	public void update()
	{
		//System.out.println("Stats: SPEED: " + getSpeed() + " LEVEl: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STR: " + getStrength() + " MAGIC " + getMagic());
	}
	*/
	public void addItem(Item item)
	{
		System.out.println("You just picked up an item!");
	}
	//getters
	public int getLevel()
	{
		if (!levelable)
			return level;
		
		
		double x = xp;
		
		double a = Math.sqrt(243 * (x * x) + 4050 * x + 17500);
		double c = ((3*x+25)/25);
		double d = Math.cbrt(a/LEVEL_CONST + c);
		
		return (int)(d - 1.0/d * 3)-1;
	}
	
	
	public int getMaxHealth()
	{
		return getLevel()*10;
	}
	public int getCurrentHealth()
	{
		int max = getMaxHealth();
		if (health>max)
			health = max;
		return health;
	}
	public float getStrength()
	{
		return getLevel()*4f;
	}
	
	public float getMagic()
	{
		return getLevel()*4f;
	}

	public float getSpeed()
	{
		return 4f;
	}
	public void damage(int amt)
	{
		health -= amt;
	}
}
