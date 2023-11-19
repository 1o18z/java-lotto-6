package lotto;

import lotto.controller.LottoGameController;

public class Application {

    private static final LottoGameController controller = new LottoGameController();

    public static void main(String[] args) {
        controller.run();
    }
}
