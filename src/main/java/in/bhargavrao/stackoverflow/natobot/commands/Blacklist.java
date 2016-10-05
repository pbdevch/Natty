package in.bhargavrao.stackoverflow.natobot.commands;

import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.event.PingMessageEvent;
import in.bhargavrao.stackoverflow.natobot.utils.CommandUtils;
import in.bhargavrao.stackoverflow.natobot.utils.FileUtils;

import java.io.IOException;

/**
 * Created by bhargav.h on 30-Sep-16.
 */
public class Blacklist implements SpecialCommand {

    private PingMessageEvent event;
    private String message;

    public Blacklist(PingMessageEvent event) {
        this.event = event;
        this.message = event.getMessage().getPlainContent();
    }

    @Override
    public boolean validate() {
        return CommandUtils.checkForCommand(message,"blacklist");
    }

    @Override
    public void execute(Room room) {
        try {
            String filename = "./lib/BlackListedWords.txt";
            String data = CommandUtils.extractData(message);
            if (FileUtils.checkIfInFile(filename, data)) {
                room.replyTo(event.getMessage().getId(), "Already Blacklisted");
            }
            else{
                FileUtils.appendToFile(filename,data);
                room.replyTo(event.getMessage().getId(), "Added blacklist Successfully");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            room.replyTo(event.getMessage().getId(), "Error occured, Try again");
        }
    }
}
