package pl.tamborskiszymon.lotto;

import pl.tamborskiszymon.lotto.logic.LottoAccuracyCalculator;
import pl.tamborskiszymon.lotto.logic.LottoNumberGenerator;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;
import pl.tamborskiszymon.model.GameResult;
import pl.tamborskiszymon.model.GameResultInfo;

import java.util.Scanner;
import java.util.Set;

public class LottoGame implements LotteryGame {

    private final Scanner scanner;
    private final LottoInputReceiver lottoInputReceiver;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoAccuracyCalculator lottoAccuracyCalculator;

    public LottoGame(Scanner scanner,
                     LottoInputReceiver lottoInputReceiver,
                     LottoNumberGenerator lottoNumberGenerator,
                     LottoAccuracyCalculator lottoAccuracyCalculator) {
        this.scanner = scanner;
        this.lottoInputReceiver = lottoInputReceiver;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoAccuracyCalculator = lottoAccuracyCalculator;
    }

    @Override
    public GameResult startGame() {
        System.out.println(String.format(LottoMessageProvider.GAME_X_STARTED, LottoMessageProvider.GAME_NAME));
        final GameResultInfo gameResultInfo = checkNumbersAccuracy();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo checkNumbersAccuracy() {
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers();
        final Set<Integer> generatedNumbers = lottoNumberGenerator.generateWinningNumbers();
        return lottoAccuracyCalculator.getAccuracyNumbers(generatedNumbers, userInputNumbers);
    }

    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }
}
