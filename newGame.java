import java.util.*;
public class newGame
{ 
	public static void main (String[]args)
	{
        CharacterCustomization characterCustomization = new CharacterCustomization();
        characterCustomization.Customization();
        System.out.println("Character Created!");
        /*
        XStreamInit();
        XStreamSave(player);
        System.out.println("Saving player!");
        XStreamLoad(player);
        System.out.println("Loading player!");
        */
	}
	/*
	public static void XStreamInit()
	{
        XStream xstream = new XStream(new DomDriver());
        Scanner keyboard = new Scanner(System.in);   
        xstream.alias("player", Player.class);
	}
	public static void XStreamSave(Player player)
	{
        String xml = xstream.toXML(player);
	}
	public static void XStreamLoad(Player player)
	{
        Player player = (Player)xstream.fromXML(xml);
	}
	*/
}
/*
xstream.alias("person", Person.class);
xstream.alias("phonenumber", PhoneNumber.class);
*/
