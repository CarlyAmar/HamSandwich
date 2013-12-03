package com.ham.gameobject;


public class CookieMonster extends Enemy
{
	public static int SIZE = 32;

	public CookieMonster(float x, float y, int level)
	{
		super(level);
		this.init(x, y, 0.2f, 0.2f, 1.0f, SIZE, SIZE, 0);
		setAttackDelay(1000);
	}
}
