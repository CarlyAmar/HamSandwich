import java.util.*;
public class CharacterCustomization
{
    public CharacterCustomization()
    {
    }
    public static void Customization()
    {
        Scanner keyboard = new Scanner(System.in);
        int skillPoints = 100;
        String[] skillAssign = new String[100];
        int newMaxHealth = 0;
        int newMaxMagic = 0;
        int newMaxStamina = 0;
        int assignmentValue = 0;
        boolean isDone = false;
        System.out.println("Welcome to character customization, you have 100 points to allocate to your skills.");
        System.out.println("To allocate points, type name of skill, followed by the points you want to assign (blank for positive, - for negative, ex. -5)");
        System.out.println("Put Skill on one line, and press enter, then the value on the next line");
        System.out.println("Type \"stats\" to view full stats at any time");
        System.out.println("Type \"done\" to finish");
        for (int i=0; isDone == false; i++)
        {
            skillAssign[i] = keyboard.nextLine();
            
            if (skillPoints == 0)
            {
                System.out.println("Max Health: " + newMaxHealth);
                System.out.println("Max Magic: " + newMaxMagic);
                System.out.println("Max Stamina: " + newMaxStamina);
                System.out.println("Skill points left: " + skillPoints);
                System.out.println("Type \"done\"to finish");
            }
            if ((!(skillAssign[i].equalsIgnoreCase("stats"))) && (!(skillAssign[i].equalsIgnoreCase("done"))))
            {
                assignmentValue = keyboard.nextInt();
                if (((skillAssign[i].equalsIgnoreCase("health"))) && (skillPoints - assignmentValue >=0))
                {
                    System.out.println("Added " + assignmentValue + " points to Health!");
                    skillPoints = (skillPoints - assignmentValue);
                    newMaxHealth = (assignmentValue + newMaxHealth);
                }
                else if ((skillAssign[i].equalsIgnoreCase("magic")) && (skillPoints - assignmentValue >=0))
                {
                    System.out.println("Added " + assignmentValue + " points to Magic!");
                    skillPoints = (skillPoints - assignmentValue);
                    newMaxMagic = (assignmentValue + newMaxMagic);
                }
                else if ((skillAssign[i].equalsIgnoreCase("stamina")) && (skillPoints - assignmentValue >=0))
                {
                    System.out.println("Added " + assignmentValue + " points to Stamina!");
                    skillPoints = (skillPoints - assignmentValue);
                    newMaxStamina = (assignmentValue + newMaxStamina);
                }
                else
                {
                    System.out.println("Sorry, I could not read that!");
                    System.out.println(skillAssign[i].equals("stats"));
                    System.out.println(skillPoints - assignmentValue >=0);
                    continue;
                }
            }
            else if (skillAssign[i].equals("stats"))
            {
                System.out.println("Max Health: " + newMaxHealth);
                System.out.println("Max Magic: " + newMaxMagic);
                System.out.println("Max Stamina: " + newMaxStamina);
                System.out.println("Skill points left: " + skillPoints);
            }
            else if (skillAssign[i].equalsIgnoreCase("done")) 
            {
                isDone = true;
            }
            else
            {
                System.out.println("Sorry, I could not read that!");
            }
        }
        System.out.println("Are you sure this is the setup you want? [y] [n]");
        System.out.println("Max Health: " + newMaxHealth);
        System.out.println("Max Magic: " + newMaxMagic);
        System.out.println("Max Stamina: " + newMaxStamina);
        System.out.println("Skill points left: " + skillPoints);
        //skillAssign = keyboard.nextLine();
        if (((keyboard.nextLine()).equalsIgnoreCase("y")) || ((keyboard.nextLine()).equalsIgnoreCase("yes")))
        {
            Player player = new Player(newMaxHealth, newMaxMagic, newMaxStamina);
        }
        else
        {
            isDone = false;
        }
    }   
}
