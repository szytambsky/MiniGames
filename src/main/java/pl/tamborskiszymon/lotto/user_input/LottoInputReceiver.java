package pl.tamborskiszymon.lotto.user_input;

import pl.tamborskiszymon.lotto.config.LottoConfiguration;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;

import java.util.*;

public class LottoInputReceiver {

    public Set<Integer> getSixNumbers() {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput() {
        final Set<Integer> givenNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format(LottoMessageProvider.PLEASE_GIVE_NUMBER, LottoMessageProvider.HOW_MANY_NUMBERS));
        while (areLessThanNeededNumers(givenNumbers)) {
            System.out.println(String.format(LottoMessageProvider.NOT_ENOUGH_NUMBER));
            while (!scanner.hasNextInt()) {
                System.out.println(String.format(LottoMessageProvider.NUMBER_NOT_IN_RANGE));
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
        int howManyNumbers = LottoMessageProvider.HOW_MANY_NUMBERS;
        if (givenNumbers.size() < howManyNumbers) {
            return true;
        }
        return false;
    }

    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        int howManyNumbers = LottoMessageProvider.HOW_MANY_NUMBERS;
        if (givenNumbers.size() < howManyNumbers) {
            if (LottoConfiguration.LOWER_RANGE <= userInput && userInput <= LottoConfiguration.HIGHER_RANGE) {
                givenNumbers.add(Integer.valueOf(userInput));
            } else {
                System.out.println(String.format(LottoMessageProvider.NUMBER_NOT_IN_RANGE));
            }
        }
    }
}
