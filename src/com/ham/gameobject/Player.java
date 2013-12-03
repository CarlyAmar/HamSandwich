package com.ham.gameobject;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.ham.engine.GameObject;
import com.ham.game.Delay;
import com.ham.game.Game;
import com.ham.game.Time;
import com.ham.game.Util;
import com.ham.gameobject.item.Item;

public class Player extends StatObject
{
	public static final float SIZE = 32;
	public static final int FORWARD = 0;
	public static final int BACKWARD = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	private Inventory inventory;
	private Equipment equipment;
	
	private Delay attackDelay;
	private int attackRange;
	private int facingDirection;
	private int attackDamage;
	
	public static final double LEVEL_CONST = Math.pow(3,(3.0/2.0));
	
	
	public Player(float x, float y)
	{
		init(x,y,0.1f,1f,0.25f,SIZE,SIZE,PLAYER_ID);
		stats = new Stats(0, true);
		inventory = new Inventory(20);
		equipment = new Equipment(inventory);
		attackDelay = new Delay(500);
		attackRange = 49;
		attackDelay.terminate();
		facingDirection = 0;
		attackDamage = 1;
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
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackDelay.isOver())
		{
			attack();
		}
	}
	public void attack()
	{
		//Find objects in attack range
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		
		if(facingDirection == FORWARD)
			objects = Game.rectangleCollide(x, y, x + SIZE, y + attackRange);
		else if(facingDirection == BACKWARD)
			objects = Game.rectangleCollide(x, y - attackRange + SIZE, x + SIZE, y);
		else if(facingDirection == LEFT)
			objects = Game.rectangleCollide(x - attackRange + SIZE, y, x, y + SIZE);
		else if(facingDirection == RIGHT)
			objects = Game.rectangleCollide(x, y, x + attackRange, y + SIZE);
		//Find which objects are enemies
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		for (GameObject go : objects)
		{
			if(go.getType() == ENEMY_ID)
				enemies.add((Enemy)go);
		}
		//find closest enemy if one exists
		if (enemies.size() > 0)
		{
			Enemy target = enemies.get(0);
			
			if(enemies.size() > 1)
			{
				for(Enemy e : enemies)
				{
					if(Util.dist(x, y, e.getX(), e.getY()) < Util.dist(x, y, target.getX(), target.getY()))
						target = e;
				}
			}
			//Attack the enemy
			target.damage(attackDamage);
		}
		
		attackDelay.restart();
	}
	private void move(float magX, float magY)
	{
		if(magX == 0 && magY == 1)
			facingDirection = FORWARD;
		if(magX == 0 && magY == -1)
			facingDirection = BACKWARD;		
		if(magX == -1 && magY == 0)
			facingDirection = LEFT;	
		if(magX == 1 && magY == 0)
			facingDirection = RIGHT;		
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
		ArrayList<GameObject> objects = Game.rectangleCollide(x, y, x+ SIZE, y+ SIZE);
		for (GameObject go : objects)
			if(go.getType() == GameObject.ITEM_ID)
			{
				System.out.println("You just picked up " + ((Item)go).getName() + "!");
				go.remove();
				addItem((Item) go);
			}
	}
	public void addItem(Item item)
	{
		inventory.add(item);
	}
}
