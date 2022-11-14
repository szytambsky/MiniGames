package user_input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.DataProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class LottoInputReceiverTest {

    @Test
    public void getSixNumbers_allNumbersInRangeAndTheSame_resultEqual() {
        Set<Integer> expectedNumbers = new HashSet<>(Arrays.asList(11,22,33,44,55,66));
        String givenNumbers = "11 22 33 44 55 66";
        Scanner scanner = mockScanner(givenNumbers);
        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        Assertions.assertEquals(expectedNumbers, userInputNumbers);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(0,3,0),
                Arguments.of(-1,5,-5)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void multiply_withDataFromMethod_resultsFromData(int first, int second, int expectedResult) {
        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

        int result = lottoInputReceiver.multiply(first, second);

        Assertions.assertEquals(expectedResult, result);
    }

    private Scanner mockScanner(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}
