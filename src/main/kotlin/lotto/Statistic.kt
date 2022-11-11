package lotto

class Statistic(private val ranks: List<Int>) {
    enum class Money(val money: Int, val index: Int) {
        FIRST(2000000000, 1),
        SECOND(30000000, 2),
        THIRD(1500000, 3),
        FOURTH(50000, 4),
        FIFTH(5000, 5);
    }

    fun statisticMessage() {
        println(TITLE)
        println(DASH)
        println("$RANK_FIFTH ${ranks[Money.FIFTH.index]}$END")
        println("$RANK_FOURTH ${ranks[Money.FOURTH.index]}$END")
        println("$RANK_THIRD ${ranks[Money.THIRD.index]}$END")
        println("$RANK_SECOND ${ranks[Money.SECOND.index]}$END")
        println("$RANK_FIRST ${ranks[Money.FIRST.index]}$END")
    }

    companion object {
        const val TITLE = "당첨 통계"
        const val DASH = "---"
        const val RANK_FIFTH = "3개 일치 (5,000원) -"
        const val RANK_FOURTH = "4개 일치 (50,000원) -"
        const val RANK_THIRD = "5개 일치 (1,500,000원) -"
        const val RANK_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) -"
        const val RANK_FIRST = "6개 일치 (2,000,000,000원) -"
        const val END = "개"
    }

}