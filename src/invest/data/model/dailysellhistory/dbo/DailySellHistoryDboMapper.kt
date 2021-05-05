package invest.data.model.dailysellhistory.dbo

import invest.data.common.CommonRepository
import invest.domain.model.dailysellhistory.DailySellHistory

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


