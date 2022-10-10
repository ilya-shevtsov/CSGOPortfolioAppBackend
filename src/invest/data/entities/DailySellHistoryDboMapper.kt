package invest.data.entities

import invest.data.CommonRepository
import invest.domain.DailySellHistory

object DailySellHistoryDboMapper {

    private val commonRepository = CommonRepository()

    fun map(caseName: String, dailySellHistory: DailySellHistory): DailySellHistoryDbo {
        return DailySellHistoryDbo(
            id = commonRepository.assignId(caseName),
            name = caseName,
            date = dailySellHistory.date,
            price = dailySellHistory.price,
            volume = dailySellHistory.volume
        )
    }
}


