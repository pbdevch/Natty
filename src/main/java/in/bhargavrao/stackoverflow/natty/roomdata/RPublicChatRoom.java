package in.bhargavrao.stackoverflow.natty.roomdata;

import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.event.MessageReplyEvent;
import fr.tunaki.stackoverflow.chat.event.UserMentionedEvent;
import in.bhargavrao.stackoverflow.natty.commandlists.RPublicCommandsList;
import in.bhargavrao.stackoverflow.natty.commandlists.SoBoticsCommandsList;
import in.bhargavrao.stackoverflow.natty.printers.PostPrinter;
import in.bhargavrao.stackoverflow.natty.printers.RPublicPostPrinter;
import in.bhargavrao.stackoverflow.natty.printers.SoBoticsPostPrinter;
import in.bhargavrao.stackoverflow.natty.utils.PostUtils;
import in.bhargavrao.stackoverflow.natty.validators.AllowAllNewAnswersValidator;
import in.bhargavrao.stackoverflow.natty.validators.RPublicValidator;
import in.bhargavrao.stackoverflow.natty.validators.Validator;

import java.util.function.Consumer;

/**
 * Created by bhargav.h on 28-Dec-16.
 */
public class RPublicChatRoom implements BotRoom{
    @Override
    public long getRoomId() {
        return 25312;
    }

    @Override
    public Consumer<UserMentionedEvent> getMention(Room room) {
        return event->new RPublicCommandsList().mention(room, event, true);
    }

    @Override
    public Consumer<MessageReplyEvent> getReply(Room room) {
        return null;
    }

    @Override
    public Validator getValidator() {
        return new RPublicValidator();
    }

    @Override
    public double getNaaValue() {
        return -10;
    }

    @Override
    public PostPrinter getPostPrinter() {
        return new RPublicPostPrinter();
    }

    @Override
    public boolean getIsLogged() {
        return false;
    }


}
