package pl.tamborskiszymon.lotto;

import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class LottoGame implements LotteryGame {

    private final Scanner scanner;
    private final LottoInputReceiver lottoInputReceiver;

    public LottoGame(Scanner scanner, LottoInputReceiver lottoInputReceiver) {
        this.scanner = scanner;
        this.lottoInputReceiver = lottoInputReceiver;
    }

    @Override
    public String startGame() {
        System.out.println(String.format(LottoMessageProvider.GAME_STARTED));
        final String gameResultInfo = checkNumbersConvergence();
        return "gamestarted: " + gameResultInfo;
    }

    @Override
    public String checkNumbersConvergence() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers();
        System.out.println(Arrays.asList(inputNumbers));
        return "we are checking numbers from user in convergence with random ones";
    }

    @Override
    public String getGameResult() {
        return "game result";
    }
}
