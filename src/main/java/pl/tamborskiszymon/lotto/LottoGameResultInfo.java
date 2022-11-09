package pl.tamborskiszymon.lotto;

import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.model.GameResultInfo;

import java.util.Set;

public class LottoGameResultInfo implements GameResultInfo {
    private final Set<Integer> generatedWinNumbers;
    private final Set<Integer> userInputNumbers;
    private final Set<Integer> finalAccurateNumbers;

    public LottoGameResultInfo(Set<Integer> generatedWinNumbers, Set<Integer> userInputNumbers, Set<Integer> finalAccurateNumbers) {
        this.generatedWinNumbers = generatedWinNumbers;
        this.userInputNumbers = userInputNumbers;
        this.finalAccurateNumbers = finalAccurateNumbers;
    }


    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvider.LOTTO_RESULT, finalAccurateNumbers.size(), generatedWinNumbers, userInputNumbers);
    }
}
