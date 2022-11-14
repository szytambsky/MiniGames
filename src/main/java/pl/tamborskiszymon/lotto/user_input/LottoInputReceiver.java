package pl.tamborskiszymon.lotto.user_input;

import pl.tamborskiszymon.lotto.config.LottoConfiguration;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;

import java.util.*;

public class LottoInputReceiver {

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput(scanner);
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput(Scanner scanner) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessageProvider.PLEASE_GIVE_NUMBERS, LottoConfiguration.HOW_MANY_NUMBERS_FROM_USER));
        while (areLessThanNeededNumers(givenNumbers)) {
            System.out.println(String.format(LottoMessageProvider.GIVE_NUMBER));
            while (!scanner.hasNextInt()) {
                System.out.println(String.format(LottoMessageProvider.NUMBER_NOT_IN_RANGE, LottoConfiguration.LOWER_RANGE, LottoConfiguration.HIGHER_RANGE));
                while (!scanner.hasNext()) {
                    return Collections.emptySet();
                }
                scanner.next();
            }

            final int userInput = scanner.nextInt();
            validateNumber(givenNumbers, userInput);
        }

        scanner.close();
        return givenNumbers;
    }

    private boolean areLessThanNeededNumers(Set<Integer> givenNumbers) {
        return givenNumbers.size() < LottoConfiguration.HOW_MANY_NUMBERS_FROM_USER;
    }

    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isNumberInRange(userInput)) {
            givenNumbers.add(Integer.valueOf(userInput));
        } else {
            System.out.println(String.format(LottoMessageProvider.NUMBER_NOT_IN_RANGE, LottoConfiguration.LOWER_RANGE, LottoConfiguration.HIGHER_RANGE));
        }
    }

    private boolean isNumberInRange(int userInput) {
        return LottoConfiguration.LOWER_RANGE <= userInput && userInput <= LottoConfiguration.HIGHER_RANGE;
    }

    public int multiply(int first, int second) {
        return first * second;
    }
}
