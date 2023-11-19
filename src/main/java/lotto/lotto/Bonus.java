package lotto.lotto;

import lotto.view.OutputView;

import static lotto.util.Constant.INVALID_BONUS_NUMBER;
import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;

public class Bonus {

    private final int number;

    public Bonus(String letter, WinningLotto winningLotto) {
        this.number = validateNumber(letter, winningLotto);
    }

    private int validateNumber(String letter, WinningLotto winningLotto) {
        int number = Integer.parseInt(letter);
        boolean isDuplicate = checkDuplicate(winningLotto, number);
        boolean isValidRange = checkRange(number);

        if (isDuplicate && isValidRange) {
            return number;
        }
        throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
    }

    private boolean checkRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            OutputView.printInvalidBonusNumber();
            return true;
        }
        return false;
    }

    private boolean checkDuplicate(WinningLotto winningLotto, int number) {
        if (winningLotto.getNumbers().contains(number)) {
            OutputView.printInvalidBonusNumber();
            return true;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
