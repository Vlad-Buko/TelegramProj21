package keyboardMarkup;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;

public class MessageKeyboard {
    public InlineKeyboardMarkup sendInlineKeyBoardMessage() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Рассылка");
        inlineKeyboardButton1.setCallbackData("SMS");
        inlineKeyboardButton2.setText("Создать");
        inlineKeyboardButton2.setCallbackData("Create");
        inlineKeyboardButton3.setText("База");
        inlineKeyboardButton3.setCallbackData("Database");
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(inlineKeyboardButton1);
        keyboardButtonsRow.add(inlineKeyboardButton2);
        keyboardButtonsRow.add(inlineKeyboardButton3);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
