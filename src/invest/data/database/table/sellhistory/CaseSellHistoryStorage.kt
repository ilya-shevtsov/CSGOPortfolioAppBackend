package invest.data.database.table.sellhistory

import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.day
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.ZoneOffset

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
    fun getPriceListQuery(): Query {
        return CaseSellHistoryTable
            .slice(
                CaseSellHistoryTable.name,
                CaseSellHistoryTable.caseId,
                CaseSellHistoryTable.date,
                CaseSellHistoryTable.price,
            ).selectAll()
            .groupBy(
                CaseSellHistoryTable.caseId,
                CaseSellHistoryTable.date,
            )
            .orderBy(CaseSellHistoryTable.date to SortOrder.ASC)
    }
}