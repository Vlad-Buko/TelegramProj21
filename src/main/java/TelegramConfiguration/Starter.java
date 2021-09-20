package TelegramConfiguration;


import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Starter {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot bot = new Bot();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(bot);
        } catch (
                TelegramApiException e) {
            e.printStackTrace();
        }
    }
}