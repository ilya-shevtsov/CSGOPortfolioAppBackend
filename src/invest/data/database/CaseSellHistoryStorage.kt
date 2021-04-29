package invest.data.database

import invest.data.database.table.CaseSellHistoryTable
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import org.jetbrains.exposed.sql.insert

object CaseSellHistoryStorage {

    fun insertToCaseSellHistoryTable(dailySellHistoryDbo: DailySellHistoryDbo) {
        CaseSellHistoryTable.insert {
            it[caseId] = dailySellHistoryDbo.id
            it[name] = dailySellHistoryDbo.name
            it[date] = dailySellHistoryDbo.date
            it[price] = dailySellHistoryDbo.price
            it[volume] = dailySellHistoryDbo.volume
        }
    }
}