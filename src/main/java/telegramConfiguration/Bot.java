package telegramConfiguration;
import CheckSymbol.CheckLanguagesSymbal;
import Documentation.AddFileDocument;
import EditDocument.EditDocument;
import GoogleCloud.DriveQuickstart;
import KeyboardMarkup.MessageKeyboard;
import Values.Steps;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Bot extends TelegramLongPollingBot{
    String step = "";
    AddFileDocument transf = new AddFileDocument();
    DriveQuickstart go = new DriveQuickstart();

    private static final String TOKEN = "unknown";
    private static final String USERNAME = "belakryly-vd";

    public String getBotToken() {
        return TOKEN;
    }

    public String getBotUsername() {
        return USERNAME;
    }

    public void onUpdateReceived(Update update) {
        EditDocument edit = new EditDocument();
        CheckLanguagesSymbal op = new CheckLanguagesSymbal();
        if (update.hasMessage()) {
            if (update.getMessage().getText().equalsIgnoreCase("/start")) {
                try {
                    MessageKeyboard one = new MessageKeyboard();
                    execute(new SendMessage().setChatId(update.getMessage().getChatId())
                            .setText("Вас приветствует программа <помощник бухгалтера!> V0.2").
                            setReplyMarkup(one.sendInlineKeyBoardMessage()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (update.getCallbackQuery().getData().equals("Create")) {
            edit.createName(update);
            step = Steps.STEP1.toString();
        }
        if (step.equalsIgnoreCase(Steps.STEP1.toString())) {
            op.isCyrillic(update);
            transf.setName(update.getMessage().getText());
            edit.editCodeCreate("Введите проведение операции", update);
            step = Steps.STEP2.toString();
        }
        else if (step.equalsIgnoreCase(Steps.STEP2.toString())) {
            op.isCyrillic(update);
            transf.setProcedure(update.getMessage().getText());
            step = Steps.STEP3.toString();
            edit.editCodeCreate("Дата", update);
        }
        else if (step.equalsIgnoreCase(Steps.STEP3.toString())) {
            transf.setDate(update.getMessage().getText());
            step = Steps.STEP4.toString();
            edit.editCodeCreate("Нахождение обьекта", update);
        }
        else if (step.equalsIgnoreCase(Steps.STEP4.toString())) {
            op.isCyrillic(update);
            transf.setLocation(update.getMessage().getText());
            edit.saveEditConfig(update);
            try {
                go.main();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (GeneralSecurityException generalSecurityException) {
                generalSecurityException.printStackTrace();
            }
        }
        else if (update.getCallbackQuery().getData().equals("SMS")) {
            edit.smsAlarm(update);
        }
        else if (update.getCallbackQuery().getData().equals("Database")) {
            edit.googleDriveWatch(update);
        }
    }
}
