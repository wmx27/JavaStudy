package Chapter12;

import java.net.URL;
        import java.util.Scanner;
        import java.util.ArrayList;

public class work12point33 {
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a urlString : ");
        String urlString = input.nextLine();
        System.out.print("Enter a word: ");
        String word = input.next();
        input.nextLine();

        findWord(word, urlString);
    }

    public static void findWord(String word, String startString)
    {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startString);
        boolean succ = true;
        while (succ)
        {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString))
            {
                listOfTraversedURLs.add(urlString);
                if (getWord(word, urlString))
                {
                    System.out.println(urlString);
                    System.exit(1);
                }

                for (String everyURL : getSubURLs(urlString))
                {
                    if (!listOfTraversedURLs.contains(everyURL))
                    {
                        listOfPendingURLs.add(everyURL);
                    }
                }
            }

            if (listOfPendingURLs.size() == 0)
            {
                System.out.println("Not fild " + word);
                succ = false;
            }
        }
    }

    public static boolean getWord(String word, String urlString)
    {
        try
        {
            Scanner input = new Scanner(new URL(urlString).openStream());
            while (input.hasNextLine())
            {
                String everyLine = input.nextLine();
                if (everyLine.contains(word))
                {
                    return true;
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public static ArrayList<String> getSubURLs(String urlString)
    {
        ArrayList<String> list = new ArrayList<>();

        try
        {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext())
            {
                String line = input.nextLine();
                current = line.indexOf("http:");
                while (current > 0)
                {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0)
                    {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}
