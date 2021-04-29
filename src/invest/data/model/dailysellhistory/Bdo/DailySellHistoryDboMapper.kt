package invest.data.model.dailysellhistory.Bdo

import invest.domain.model.DailySellHistory

object DailySellHistoryDboMapper {

    fun map(caseName: String, dailySellHistory: DailySellHistory): DailySellHistoryDbo {

        val caseId = when (caseName){
            "Chroma Case" -> 1
            "Chroma 2 Case" -> 2
            "Chroma 3 Case" -> 3
            "Clutch Case" -> 4
        }

    }
}

DailySellHistory(date=Tue Mar 21 01:00:00 MSK 2017, price=327.834, volume=47382)