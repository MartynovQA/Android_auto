package autotest.android.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zaborovsky on 05.01.2017.
 */
public class Utils {

    private static final String[] SPECIAL_CHARACTERS = {"."};
    private static long lastTimeStamp = System.currentTimeMillis();

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String parseXpath(String parse) {
        String result;
        Pattern pattern = Pattern.compile("->xpath:.*");
        Matcher m = pattern.matcher(parse);
        m.find();
        result = m.group();
        return result.replace("]] -> xpath: ", "").replace("-> xpath: ", "").replaceAll("]]]", "]").replaceAll("]]", "]");
    }

    public static String getFullXpath(By... byIn) {
        String fullXpath = "";
        for (By by :byIn)
            fullXpath += by.toString();
        for (String element : SPECIAL_CHARACTERS) {
            fullXpath = fullXpath.replace(element, "");
        }
        return fullXpath;
    }

    public static String getFullXpath(SearchContext context, By... byIn){
        String fullXpath = "";
        String parent = parseXpath(context.toString());
        for (By by :byIn)
            fullXpath += by.toString();
        for (String element : SPECIAL_CHARACTERS) {
            fullXpath = fullXpath.replace(element, "");
        }
        return fullXpath;
    }

    public synchronized static String getUnique() {
        long currentTimeStamp = System.currentTimeMillis();
        if (lastTimeStamp < currentTimeStamp) {
            lastTimeStamp = currentTimeStamp;
        } else  {
            lastTimeStamp += 1;
        }
        final String sUnique = String.valueOf(lastTimeStamp) + String.valueOf(Math.round(Math.random()*1000));
        char[] chars = sUnique.toCharArray();

        for (int i = 0; i < sUnique.length(); i++){
            chars[i] += 'A' - '0';
        }
        return new String(chars);
    }

    public synchronized static String getNewUnique() {
        Random r = new Random();
        char[] chars = new char[10];
        for (int i = 0; i < 10; i++) {
            chars[i] = (char) (r.nextInt(90-65+1) + 65);
        }
        return new String(chars);
    }

    public static String getNumber(int length) {
        Random rnumber = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(Integer.toString(rnumber.nextInt(10)));
        }
        return buf.toString();
    }

    public static int getNumberFromTo(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to - from);
    }

    public static String getEmail() {
        return getUnique() + "@" + "grr.la";
    }

    public static String match (String regex, String parse) {
        Pattern pattern;
        Matcher m;
        pattern = Pattern.compile(regex);
        m = pattern.matcher(parse);
        m.find();
        return m.group(0);
    }

    public static ArrayList<String> matchWhile(String regex, String parse) {
        Pattern pattern;
        Matcher m;
        ArrayList<String> match = new ArrayList<>();
        pattern = Pattern.compile(regex);
        m = pattern.matcher(parse);
        while (m.find()) {
            match.add((m.group()));
        }
        return match;
    }

    public static boolean isMatch (String regex, String parse) {
        Pattern pattern;
        Matcher m;
        pattern = Pattern.compile(regex);
        m = pattern.matcher(parse);
        return m.find();
    }

//    TODO: io stacktrace: from stream, from string

    public static File saveFile(String filename, InputStream input) {
        File file = new File(filename);
//        try {
//        filewriter
//        } catch (IOException e) {
//        e.printStackTrace();
//    }

        return file;
    }

    public static File saveFile(String filename, String input) {
        File file = new File(filename);
//        try {
//        filewriter
//        } catch (IOException e) {
//        e.printStackTrace();
//    }

        return file;
    }

    public static Object deserializeObject(String fileName) {
        FileInputStream fis;
        Object obj = null;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T extends Serializable> void serializeObject(T obj, String fileName) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
