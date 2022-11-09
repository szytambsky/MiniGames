package pl.tamborskiszymon.lotto.message_provider;

public class LottoMessageProvider {
    public static final String GIVE_NUMBER = "Please give number";
    public static final String PLEASE_GIVE_NUMBERS = "Please give %d numbers";
    public static final String NUMBER_NOT_IN_RANGE = "Please provide a number in permitted range, %d-%d";

    public static final String NOT_ENOUGH_NUMBERS = "Please give consecutive number:";
    public static final String GAME_X_STARTED = "Game: %s started";
    public static final String GAME_NAME = "Lotto";

    public static final String RESULT_HITTED = "You hit %d numbers correctly, Winning were %s and your %s";



    private LottoMessageProvider() {
    }
}
