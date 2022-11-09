package pl.tamborskiszymon.lotto.message_provider;

public class LottoMessageProvider {
    public static final String PLEASE_GIVE_NUMBER = "Please provide numbers:";
    public static final String NUMBER_NOT_IN_RANGE = "Please provide a number in permitted range";

    public static final String NOT_ENOUGH_NUMBER = "Please give consecutive number:";
    public static final String GAME_STARTED = "Game: ";
    private String GAME_NAME;
    public static final int HOW_MANY_NUMBERS = 6;



    public LottoMessageProvider(String GAME_NAME) {
        this.GAME_NAME = GAME_NAME;
    }
}
