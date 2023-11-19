package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.LOTTO_PRICE;

public class Parser {

    public int parsePurchaseAmount() {
        int purchasePrice;

        while (true) {
            purchasePrice = attemptParseInt();
            if (purchasePrice < DEFAULT_VALUE) {
                OutputView.printInvalidFormat();
                continue;
            }
            if (validatePurchasePrice(purchasePrice)) {
                OutputView.newLine();
                break;
            }
            OutputView.printInvalidPurchasePriceUnit();
        }
        return purchasePrice;
    }

    private boolean validatePurchasePrice(int purchasePrice) {
        return purchasePrice % LOTTO_PRICE == DEFAULT_VALUE;
    }

    private int attemptParseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int attemptParseInt() {
        return attemptParseInt(Console.readLine());
    }
}
