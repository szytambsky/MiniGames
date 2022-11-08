package pl.tamborskiszymon;

import pl.tamborskiszymon.lotto.LottoGame;
import pl.tamborskiszymon.lotto.message_provider.LottoMessageProvider;
import pl.tamborskiszymon.lotto.user_input.LottoInputReceiver;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LottoMessageProvider lottoMessageProvider = new LottoMessageProvider();
        LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

        LottoGame lottoGame = new LottoGame(scanner, lottoMessageProvider, lottoInputReceiver);
        System.out.println(lottoGame.startGame());

    }
}