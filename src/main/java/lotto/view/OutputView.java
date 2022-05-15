package lotto.view;

import lotto.constant.ViewMessageConst;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;

public class OutputView {
    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PURCHASED_SIZE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_WINNING_STATISTIC);
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_DIVIDE_LINE);
        printWinningCount(result);
        printProfitRate(result);
    }

    private static void printWinningCount(LottoResult result) {
        for(LottoRank rank : LottoRank.rankListWithReverseOrder()){
            System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_WINNING_COUNT_RESULT,
                    rank.getMatchedCount(), rank.getPrice(),
                    result.winningCountByRank(rank)));
        }
    }

    private static void printProfitRate(LottoResult result) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PROFIT_RESULT, result.getProfitRate()));
    }
}
