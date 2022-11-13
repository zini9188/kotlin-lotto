package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constant
import lotto.util.ErrorMessage

class LottoMachine(amount: String) {
    private var lottoCount = 0
    private val lottery = mutableListOf<Lotto>()

    init {
        validateType(amount)
        validateRemainder(amount)
        lottoCount = calculateLottoCount(amount)
    }

    fun validateType(amount: String) {
        val typeCount = amount.filter {
            it in '0'..'9'
        }
        require(typeCount.length == amount.length) {
            ErrorMessage.integer(Constant.LOTTO_AMOUNT)
        }
    }

    fun validateRemainder(amount: String) = require(amount.toInt() % Constant.LOTTO_PRICE == Constant.REMAINDER) {
        ErrorMessage.unit(Constant.LOTTO_AMOUNT)
    }

    private fun calculateLottoCount(amount: String) = amount.toInt() / Constant.LOTTO_PRICE

    fun pickNewLottery(count: Int) {
        for (index in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Constant.START_LOTTO_RANGE, Constant.END_LOTTO_RANGE, Constant.LOTTO_COUNT
            )
            lottery.add(Lotto(numbers))
        }
    }

    fun getLottoCount() = lottoCount

    fun getLottery() = lottery

    fun getRanks(winningNumber: List<Int>, bonusNumber: Int): List<Int> {
        val ranks = MutableList(Constant.LOTTO_COUNT) { 0 }
        lottery.forEach {
            val rankIndex = it.checkWinning(winningNumber, bonusNumber)
            ranks[rankIndex]++
        }
        return ranks
    }
}