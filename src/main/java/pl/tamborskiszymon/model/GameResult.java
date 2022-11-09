package pl.tamborskiszymon.model;

import pl.tamborskiszymon.lotto.LotteryGame;

public class GameResult {
    private final LotteryGame lotteryGame;
    private final GameResultInfo gameResultInfo;

    public GameResult(LotteryGame lotteryGame, GameResultInfo gameResultInfo) {
        this.lotteryGame = lotteryGame;
        this.gameResultInfo = gameResultInfo;
    }

    public GameResultInfo getGameResultInfo() {
        return gameResultInfo;
    }

}
