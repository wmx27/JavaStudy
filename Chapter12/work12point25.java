package Chapter12;
import java.util.Scanner;
import java.net.URL;

public class work12point25
{
    public static void main(String [] args) throws Exception
    {
        URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
        Scanner input = new Scanner(url.openStream());
        double assistant = 0.0;
        int countAssistant = 0;
        double associate = 0.0;
        int countAssociate = 0;
        double full = 0.0;
        int Full = 0;
        while (input.hasNext())
        {
            String line = input.nextLine();
            String[] message = line.split(" ");
            if (message[2].equals("assistant"))
            {
                assistant += Double.parseDouble(message[3]);
                countAssistant++;
            }
            else if (message[2].equals("associate"))
            {
                associate += Double.parseDouble(message[3]);
                countAssociate++;
            }
            else if (message[2].equals("full"))
            {
                full += Double.parseDouble(message[3]);
                Full++;
            }
        }

        System.out.println("Assistant total " + assistant + ", Average " + (assistant / countAssistant));
        System.out.println("Associate total " + associate + ", Average " + (associate / countAssociate));
        System.out.println("Full total " + full + ", Average " + (full / Full));
    }
}
