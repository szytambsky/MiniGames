package pl.tamborskiszymon.lotto.logic;

import pl.tamborskiszymon.lotto.config.LottoConfiguration;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public Set<Integer> generateWinningNumbers() {
        Random random = new Random();
        return random.ints(LottoConfiguration.HOW_MANY_NUMBERS_FROM_USER, LottoConfiguration.LOWER_RANGE, LottoConfiguration.HIGHER_RANGE)
                .boxed()
                .collect(Collectors.toSet());
    }
}
