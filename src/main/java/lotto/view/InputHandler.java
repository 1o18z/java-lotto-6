package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.Bonus;
import lotto.lotto.WinningLotto;

import static lotto.util.Constant.LOTTO_PRICE;

public class InputHandler {

    private final Parser parser = new Parser();

    public int getPurchasedPrice() {
        int purchasedPrice = getPurchasedAmount();
        OutputView.purchaseAmount(purchasedPrice / LOTTO_PRICE);
        return purchasedPrice;
    }

    public WinningLotto getWinningLotto() {
        InputView.requestWinningNumbers();
        String inputNumbers = Console.readLine();
        WinningLotto winningLotto = new WinningLotto(inputNumbers);
        OutputView.newLine();
        return winningLotto;
    }

    public Bonus getBonusNumber(WinningLotto winningLotto) {
        InputView.requestBonusNumber();
        String inputBonusNumber = Console.readLine();
        OutputView.newLine();
        return new Bonus(inputBonusNumber, winningLotto);
    }

    private int getPurchasedAmount() {
        InputView.requestAmount();
        return parser.parsePurchaseAmount();
    }
}
