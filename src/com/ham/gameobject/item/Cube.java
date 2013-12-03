package com.ham.gameobject.item;

import com.ham.gameobject.Player;

public class Cube extends Item
{
	public static final float SIZE = 32;
	
	public Cube(float x,float y, Player play)
	{
		super(play);
		init(x,y,1.0f,0.5f,0,SIZE,SIZE,ITEM_ID);
		this.name = "Cube";
	}
}
