package com.ham.gameobject;

import org.lwjgl.input.Keyboard;

import com.ham.game.Time;
import com.ham.gameobject.item.Item;

public class Player extends StatObject
{
	public static final float SIZE = 32;
	private Inventory inventory;
	
	public static final double LEVEL_CONST = Math.pow(3,(3.0/2.0));
	
	
	public Player(float x, float y)
	{
		init(x,y,0.1f,1f,0.25f,SIZE,SIZE,PLAYER_ID);
		stats = new Stats(0, true);
		inventory = new Inventory(20);
	}
	public void getInput()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			move(0,1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			move(0,-1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			move(-1,0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			move(1,0);
		}
	}
	private void move(float magX, float magY)
	{
		x+= getSpeed() * magX * Time.getDelta();
		y+= getSpeed() * magY * Time.getDelta();
	}
	public void addXp(float amt)
	{
		stats.addXp(amt);
	}
	@Override
	public void update()
	{
		//System.out.println("Stats: SPEED: " + getSpeed() + " LEVEl: " + getLevel() + " MAXHP: " + getMaxHealth() + " HP: " + getCurrentHealth() + " STR: " + getStrength() + " MAGIC " + getMagic());
	}
	public void addItem(Item item)
	{
		inventory.add(item);
	}
}
