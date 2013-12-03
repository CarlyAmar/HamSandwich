package com.ham.gameobject;

import java.util.ArrayList;

import com.ham.engine.GameObject;
import com.ham.engine.Main;
import com.ham.game.Delay;
import com.ham.game.Time;
import com.ham.game.Util;

public class Enemy extends StatObject
{
	private StatObject target;
	private Delay attackDelay;
	public static final float DAMPING = 0.5f;
	private float attackRange = 48f;
	private int attackDamage;
	private float sightRange;
	
	public Enemy(int level)
	{
		stats = new Stats(level, false);
		target = null;
		attackRange = 48;
		attackDelay = new Delay(500);
		attackDelay.start();
		attackDamage = 1;
		sightRange = 128;
	}
	@Override
	public void update()
	{
		if(target == null)
			Look();
		else
		{	
			if(Util.lineOfSight(this, target) && (Util.dist(x, y, getTarget().getX(), getTarget().getY()) <= attackRange))
			{
				if(attackDelay.over())
					Attack();
			}
			else
				Chase();
		}
		if(stats.getCurrentHealth() <= 0)
			Death();
	}
	protected void Attack()
	{
		getTarget().damage(getAttackDamage());
		restartAttackDelay();
	}
	protected void Chase()
	{
		float speedX = getTarget().getX() - x;
		float speedY = getTarget().getY() - y;

		float maxSpeed = getStats().getSpeed()*DAMPING;
		
		if(speedX > maxSpeed)
			speedX = maxSpeed;
		if(speedX < -maxSpeed)
			speedX = -maxSpeed;
		if(speedY > maxSpeed)
			speedY = maxSpeed;
		if(speedY < -maxSpeed)
			speedY = -maxSpeed;
		
		x = x+speedX * Time.getDelta();
		y = y+speedY * Time.getDelta();
		
	}
	protected void Look()
	{
		ArrayList<GameObject> objects = Main.sphereCollide(x, y, sightRange);
			
		for (GameObject go : objects)
		{
			if(go.getType() == PLAYER_ID)
			{
				setTarget((StatObject)go);
			}
		}
	}
	protected void Death()
	{
		remove();
	}
	public void setTarget(StatObject go)
	{
		target = go;
	}
	public StatObject getTarget()
	{
		return target;
	}
	public Stats getStats()
	{
		return this.stats;
	}
	public void setAttackRange(int range)
	{
		attackRange = range;
	}
	public void setAttackDelay(int time)
	{
		attackDelay = new Delay(time);
		attackDelay.end();
	}
	public void restartAttackDelay()
	{
		attackDelay.start();
	}
	public void setAttackDamage(int amt)
	{
		attackDamage = amt;
	}
	public int getAttackDamage()
	{
		return attackDamage;
	}
	public void setSightRange(float dist)
	{
		sightRange = dist;
	}
}
