package lotto.lotto;

import java.util.Collections;
import java.util.List;

import lotto.util.Generator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Generator.generateLotto();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }
}
