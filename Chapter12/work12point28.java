package Chapter12;
import java.io.File;
import java.util.Scanner;

public class work12point28 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file path:");//这边获取路径
        File file = new File(path(input.next()));
        renameFile(file);
    }

    public static String path(String path) {
        return path.replaceAll("\\\\", "/");
    }

    public static void renameFile(File file) {
        if (getNewName(file).equals("gg")) {
            if (file.isFile()) {
                return;
            } else {
                directory(file);
            }
        } else if (file.isDirectory()) {
            directory(file);
            file(file);

        } else if (file.isFile()) {
            file(file);
        }
    }

    public static File file(File file) {
        File newFile = new File(getNewName(file));
        System.out.println(newFile.getAbsolutePath() + " " + file.renameTo(newFile));
        return newFile;
    }

    public static void directory(File file) {
        File[] subFile = file.listFiles();
        System.out.println(file.getAbsolutePath());
        for (File everyFile : subFile) {
            renameFile(everyFile);
        }
    }

    public static String getNewName(File file) {
        String name = path(file.getAbsolutePath());
        String newName = null;
        if (!name.contains("Exercise")) {
            return "gg!";
        }

        String tail = name.substring(name.lastIndexOf("Exercise"), name.length());
        if (tail.contains(".")) {
            String[] countNum = tail.split("[ercise_.]");
            if (countNum[countNum.length - 3].length() == 1) {
                countNum[countNum.length - 3] = "0" + countNum[countNum.length - 3];
            }
            newName = name.substring(0, name.lastIndexOf("Exercise")) + "Exercise" + countNum[countNum.length - 3] + "_"
                    + countNum[countNum.length - 2] + "." + countNum[countNum.length - 1];
        } else {
            String[] countNum = tail.split("[ercise_]");
            if (countNum[countNum.length - 2].length() == 1) {
                countNum[countNum.length - 2] = "0" + countNum[countNum.length - 2];
            }
            newName = name.substring(0, name.lastIndexOf("Exercise")) + "Exercise" + countNum[countNum.length - 2] + "_"
                    + countNum[countNum.length - 1];

        }
        return newName;
    }
}

