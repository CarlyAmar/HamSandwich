package com.ham.game;

import com.ham.engine.GameObject;

public class Util 
{
	public static boolean lineOfSight(GameObject go1, GameObject go2)
	{
		return true;
	}
	
	public static float dist(float x1, float y1, float x2, float y2)
	{
		float x = x2-x1;
		float y = y2-y1;
		
		return (float)Math.sqrt((x*x) + (y*y));
	}
}
