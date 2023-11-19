package lotto.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.Constant.INVALID_LOTTO_LENGTH;
import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Constant.SEPARATE_LETTER;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(String inputNumbers) {
        this.numbers = new ArrayList<>(validateNumbers(inputNumbers));
    }

    private List<Integer> validateNumbers(String numbers) {
        Set<String> set = Arrays.stream(numbers.split(SEPARATE_LETTER)).collect(Collectors.toSet());
        checkLength(set);
        return set.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void checkLength(Set<String> set) {
        if (set.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
