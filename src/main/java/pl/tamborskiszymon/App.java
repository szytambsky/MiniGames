package pl.tamborskiszymon;

import pl.tamborskiszymon.lotto.LottoGame;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

        LottoGame lottoGame = new LottoGame(scanner, lottoInputReceiver);
        System.out.println(lottoGame.startGame());
    }
}