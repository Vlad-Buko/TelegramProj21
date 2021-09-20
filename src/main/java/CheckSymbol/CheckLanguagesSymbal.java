package CheckSymbol;

import EditDocument.EditDocument;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CheckLanguagesSymbal {
    public boolean isCyrillic(Update update) {
        EditDocument edit = new EditDocument();
        boolean result = false;
        for (char a : update.getMessage().getText().toCharArray()) {
            if (Character.UnicodeBlock.of(a) != Character.UnicodeBlock.CYRILLIC) {
                result = !result;
                edit.errorLenguages(update);
                edit.createName(update);
                break;
            }
            if (update.getMessage().getText().length() > 10) {
                edit.errorLenghtSymbol(update);
                edit.createName(update);
                break;
            }
        }
        return result;
    }
}

