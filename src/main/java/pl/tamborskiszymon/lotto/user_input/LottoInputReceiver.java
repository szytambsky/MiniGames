package pl.tamborskiszymon.lotto.user_input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LottoInputReceiver {

    public Set<Integer> getSixNumbers() {
        Set<Integer> givenNumbersFromUser = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        return givenNumbersFromUser;
    }


}
