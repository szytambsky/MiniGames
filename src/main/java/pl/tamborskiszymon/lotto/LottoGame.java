package pl.tamborskiszymon.lotto;

import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class LottoGame implements LotteryGame {

    private final Scanner scanner;
    private final LottoMessageProvider lottoMessageProvider;
    private final LottoInputReceiver lottoInputReceiver;

    public LottoGame(Scanner scanner, LottoMessageProvider lottoMessageProvider, LottoInputReceiver lottoInputReceiver) {
        this.scanner = scanner;
        this.lottoMessageProvider = lottoMessageProvider;
        this.lottoInputReceiver = lottoInputReceiver;
    }

    @Override
    public String startGame() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers();
        String result = new String(Arrays.toString(inputNumbers.toArray()));
        return "gamestarted: " + result;
    }

    @Override
    public String checkNumbersConvergence() {
        return "we are checking numbers from user in convergence with random ones";
    }

    @Override
    public String getGameResult() {
        return "game result";
    }
}
