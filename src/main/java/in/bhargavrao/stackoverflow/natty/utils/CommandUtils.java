package in.bhargavrao.stackoverflow.natty.utils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by bhargav.h on 30-Sep-16.
 */
public class CommandUtils {

    public static boolean checkForCommand(String message, String command){
        return message.split(" ")[0].toLowerCase().startsWith("@fel") && message.split(" ")[1].toLowerCase().equals(command);
    }
    public static String extractData(String message){
        String parts[] = message.split(" ");
        return String.join(" ", Arrays.copyOfRange(parts,2,parts.length));
    }
    public static String checkAndRemoveMessage(String filename, String message){
        try{
            if(FileUtils.checkIfInFile(filename,message)){
                FileUtils.removeFromFile(filename,message);
                return "Done";
            }
            else {
                return ("It's not there in the file");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return ("Failed");
        }

    }
    public static String getAnswerId(String word){
        String parts[]= word.split("//")[1].split("/");
        if(parts[1].equals("a") || parts[1].equals("answers")){
            word = parts[2];
        }
        else if (parts[1].equals("q") || parts[1].equals("questions")){
            if (parts[4].contains("#"))
            {
                word = parts[4].split("#")[1];
            }
        }
        return word;
    }

}