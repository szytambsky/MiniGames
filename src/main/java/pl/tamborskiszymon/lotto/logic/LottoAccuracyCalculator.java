package pl.tamborskiszymon.lotto.logic;

import pl.tamborskiszymon.lotto.LottoGameResultInfo;

import java.util.HashSet;
import java.util.Set;

public class LottoAccuracyCalculator {

    public LottoGameResultInfo getAccuracyNumbers(Set<Integer> generatedWinNumbers, Set<Integer> userInputNumbers) {
        Set<Integer> finalAccurateNumbers = new HashSet<>(generatedWinNumbers);
        finalAccurateNumbers.retainAll(userInputNumbers);
        return new LottoGameResultInfo(generatedWinNumbers, userInputNumbers, finalAccurateNumbers);
    }
}
