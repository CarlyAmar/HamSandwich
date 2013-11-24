package Graphics;

public class graphics 
{
	static final int width = 800;
	static final int height = 600;
	//create display
	try
	{
		Display.setDisplayMode(new DisplayMode(width,height));
		Display.create();
	}
	catch
	{
		logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	//game loop
	while (!Display.isCloseRequested())
	{
		Display.update();
	}
}
