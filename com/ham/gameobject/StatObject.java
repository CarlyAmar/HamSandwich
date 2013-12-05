package com.ham.gameobject;

import com.ham.engine.GameObject;

public class StatObject extends GameObject
{
	protected Stats stats;
	
	public void damage(int amount)
	{
		stats.damage(amount);
	}
	//Getters for stats
		public int getLevel()
		{
			return stats.getLevel();
		}
		public int getMaxHealth()
		{
			return stats.getMaxHealth();
		}
		public int getCurrentHealth()
		{
			return stats.getCurrentHealth();
		}
		public float getStrength()
		{
			return stats.getStrength();
		}
		public float getMagic()
		{
			return stats.getMagic();
		}
		public float getSpeed()
		{
			return stats.getSpeed();
		}
}
