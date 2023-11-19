package lotto.controller;

import lotto.Bonus;
import lotto.LottoList;
import lotto.WinningLotto;
import lotto.result.Calculator;
import lotto.input.InputHandler;
import lotto.matching.Matcher;
import lotto.result.Result;

import static lotto.util.Constant.LOTTO_PRICE;

public class LottoGameController {

    private final Matcher matcher = new Matcher();
    private final InputHandler inputHandler = new InputHandler();
    private final Calculator calculator = new Calculator();

    public void run() {
        int purchasedPrice = inputHandler.getPurchasedPrice();
        LottoList lottoList = new LottoList(purchasedPrice / LOTTO_PRICE);
        WinningLotto winningLotto = inputHandler.getWinningLotto();
        Bonus bonusNumber = inputHandler.getBonusNumber(winningLotto);

        Result result = matcher.match(winningLotto, lottoList, bonusNumber);

        calculator.getStatistics(result.getMap());
        calculator.getProfitRate(result.getMap(), purchasedPrice);
    }
}
