package lotto.enums;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoWinningType {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(-1,0);

    private int matchedCount;
    private int price;

    LottoWinningType(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static LottoWinningType match(Lotto lotto, Lotto winningLotto) {
        int matchedCount = lotto.countMatchedNumbers(winningLotto);
        return winningTypeByMatchedCount(matchedCount);
    }

    private static LottoWinningType winningTypeByMatchedCount(int matchedCount) {
        if(matchedCount == 6)
            return FIRST;
        if(matchedCount == 5)
            return SECOND;
        if(matchedCount == 4)
            return THIRD;
        if(matchedCount == 3)
            return FOURTH;
        return LOSE;
    }

    public static List<LottoWinningType> winningTypeListWithReverseOrder() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
