package EditDocument;

import KeyboardMarkup.MessageKeyboard;
import TelegramConfiguration.Bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditDocument extends Bot {
    public void createName(Update update) {
        try {
            execute(new SendMessage().setText("Введите имя заказчика")
                    .setChatId(update
                            .getCallbackQuery().getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String editCodeCreate (String text, Update update) {
        try {
            execute(new SendMessage().setText(text)
                    .setChatId(update.getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return update.getMessage().getText();
    }
    public void saveEditConfig (Update update) {
        try {

            MessageKeyboard one = new MessageKeyboard();
            execute(new SendMessage().setChatId(update
                            .getMessage().getChatId())
                    .setText("Изменения сохранены").
                    setReplyMarkup(one.sendInlineKeyBoardMessage()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void smsAlarm (Update update) {
        try {
            execute(new SendMessage().setText("Hello")
                    .setChatId(update.getCallbackQuery()
                            .getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void googleDriveWatch (Update update) {
        try {
            execute(new SendMessage().setText("DATE")
                    .setChatId(update.getCallbackQuery()
                            .getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void errorLenguages (Update update) {
        try {
            execute(new SendMessage().setText("Переключи расскладку")
                    .setChatId(update.getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void errorLenghtSymbol (Update update) {
        try {
            execute(new SendMessage().setText("Длина превышает допустимую!")
                    .setChatId(update.getMessage().getChatId()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
