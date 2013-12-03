package com.ham.gameobject.item;

import com.ham.engine.GameObject;
import com.ham.engine.Physics;
import com.ham.engine.Sprite;
import com.ham.gameobject.Player;

public class Item extends GameObject
{
	protected String name;
	protected Sprite spr;
	protected Player player;
	
	public Item(Player play)
	{
		this.player = play;
	}
	
	public void pickUp()
	{
		System.out.println("You just picked up " + name + "!");
		player.addItem(this);
		remove();
	}
	//@Override
	public void update()
	{
		if (Physics.checkCollision(this, player) != null)
			pickUp();
	}
	protected void init(float x, float y,float r,float g,float b, float sx, float sy,String name)
	{
		this.x=x;
		this.y=y;
		this.type=ITEM_ID;
		this.spr = new Sprite(r,g,b,sx,sy);
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
