package org.hamsandwich.Graphics;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hamsandwich.newGame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window 
{
	public final int width = 800;
	public final int height = 600;
	//create display
	public void window()
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
	}
}
