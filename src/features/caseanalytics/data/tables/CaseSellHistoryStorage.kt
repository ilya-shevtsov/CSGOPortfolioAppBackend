package features.caseanalytics.data.tables

import features.caseanalytics.data.entities.DailySellHistoryDbo
import features.caseanalytics.domain.entities.CasePriceData
import org.jetbrains.exposed.sql.*
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

    fun getDailyCasePriceData(id: Int): CasePriceData {
        val list = mutableListOf<Double>()
        var case = CasePriceData("", emptyList())
        val query = getPriceListQuery()
        transaction {
            query.forEach {
                if (it[CaseSellHistoryTable.caseId] == id) {
                    list.add(it[CaseSellHistoryTable.price])
                    case = CasePriceData(
                        name = it[CaseSellHistoryTable.name],
                        priceList = list
                    )
                }
            }
        }
        return case
    }

    fun getMonthlyCasePriceData(id: Int): CasePriceData {
        val list = mutableListOf<Double>()
        var case = CasePriceData("", emptyList())
        val query = getPriceListQuery()
        transaction {
            query.forEach {
                val caseId = it[CaseSellHistoryTable.caseId]
                val date = it[CaseSellHistoryTable.date]
                if (caseId == id && date.atZone(ZoneOffset.UTC).dayOfMonth == 13) {
                    list.add(it[CaseSellHistoryTable.price])
                    case = CasePriceData(
                        name = it[CaseSellHistoryTable.name],
                        priceList = list
                    )
                }
            }
        }
        return case
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