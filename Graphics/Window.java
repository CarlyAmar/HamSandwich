package org.hamsandwich.Graphics;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hamsandwich.newGame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window 
{
	public int width = 800;
	public int height = 600;
	//create display
	public Window(int tempWidth, int tempHeight)
	{
		this.height = tempWidth;
		this.width = tempHeight;	
	}
	public void display()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
		}
		catch(LWJGLException ex)
		{
			Logger.getLogger(newGame.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		//game loop
		while (!Display.isCloseRequested())
		{
			Display.update();
		}
		Display.destroy();
	}
}
