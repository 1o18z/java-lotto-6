package lotto.lotto;

import java.util.Collections;
import java.util.List;
import lotto.util.Generator;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto() {
        this.numbers = Generator.generateLotto();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
