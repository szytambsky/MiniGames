package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import pl.tamborskiszymon.lotto.logic.LottoAccuracyCalculator;
import pl.tamborskiszymon.lotto.logic.LottoNumberGenerator;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;
import pl.tamborskiszymon.model.GameResult;
import java.util.*;
import java.util.stream.Stream;

public class LottoGameTest {

    private static final Scanner mockScanner = new Scanner(System.in);
    private static final LottoAccuracyCalculator lottoAccuracyCalculatorMock = new LottoAccuracyCalculator();
    private static final LottoInputReceiver lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
    private static final LottoNumberGenerator lottoNumberGeneratorMock = Mockito.mock(LottoNumberGenerator.class);

    @ParameterizedTest(name = "Player gave {0}, generated random numbers were {1}, result {2}")
    @MethodSource("lottoGameData")
    public void startGame_shouldReturnCorrectMessageWhenNumbersGiven(Set<Integer> givenNumbers,
                                                                      Set<Integer> generatedNumbers,
                                                                      String expectedMessage) {
        // given
        mockNumbers(givenNumbers, generatedNumbers);
        pl.tamborskiszymon.lotto.LottoGame lottoGame = new pl.tamborskiszymon.lotto.LottoGame(mockScanner,
                lottoInputReceiverMock,
                lottoNumberGeneratorMock,
                lottoAccuracyCalculatorMock);

        // when
        final GameResult gameResult = lottoGame.startGame();

        // then
        Assertions.assertEquals(gameResult.getGameResultInfo().getGameResultMessage(), expectedMessage);
    }

    private static Stream<Arguments> lottoGameData() {
        return Stream.of(
                Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                        Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                        "You hit 6 numbers correctly, Winning were [1, 2, 3, 4, 5, 6] and your [1, 2, 3, 4, 5, 6]."),
                Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(45,2,3,4,5,6))),
                        Collections.unmodifiableSet(new HashSet<>(Arrays.asList(3,2,45,4,5,6))),
                        "You hit 6 numbers correctly, Winning were [2, 3, 4, 5, 6, 45] and your [2, 3, 4, 5, 6, 45]."),
                Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        Collections.unmodifiableSet(new HashSet<>(Arrays.asList(6, 8, 9, 10, 11, 12))),
                        "You hit 1 numbers correctly, Winning were [6, 8, 9, 10, 11, 12] and your [1, 2, 3, 4, 5, 6].")
        );
    }



    private void mockNumbers(Set<Integer> givenNumbers, Set<Integer> generatedNumbers) {
        Mockito.when(lottoInputReceiverMock.getSixNumbers(mockScanner)).thenReturn(givenNumbers);
        Mockito.when(lottoNumberGeneratorMock.generateWinningNumbers()).thenReturn(generatedNumbers);
    }

    private LottoInputReceiver createInputReceiverMock(Scanner scanner, Set<Integer> givenNumbers) {
        LottoInputReceiver lottoInputReceiverMock = Mockito.mock(LottoInputReceiver.class);
        Mockito.when(lottoInputReceiverMock.getSixNumbers(scanner)).thenReturn(givenNumbers);
        return lottoInputReceiverMock;
    }

    private LottoNumberGenerator createLottoNumberGeneratorMock(Set<Integer> generatedNumebrs) {
        LottoNumberGenerator lottoNumberGenerator = Mockito.mock(LottoNumberGenerator.class);
        Mockito.when(lottoNumberGeneratorMock.generateWinningNumbers()).thenReturn(generatedNumebrs);
        return lottoNumberGenerator;
    }
}



