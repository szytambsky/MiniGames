package pl.tamborskiszymon;

import pl.tamborskiszymon.lotto.LotteryGame;
import pl.tamborskiszymon.lotto.LottoGame;
import pl.tamborskiszymon.lotto.logic.LottoAccuracyCalculator;
import pl.tamborskiszymon.lotto.logic.LottoNumberGenerator;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        App app = new App();
        final LotteryGame lotteryGame = app.getLottoGame();
        lotteryGame.startGame();
    }

    private LotteryGame getLottoGame() {
        Scanner scanner = new Scanner(System.in);
        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoAccuracyCalculator lottoAccuracyCalculator = new LottoAccuracyCalculator();
        return new LottoGame(scanner, lottoInputReceiver, lottoNumberGenerator, lottoAccuracyCalculator);
    }
}