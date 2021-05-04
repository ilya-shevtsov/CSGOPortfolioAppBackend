package invest.data.database.table.sellhistory

import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertIgnore

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