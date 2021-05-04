package invest.data.database.repository

import invest.data.database.table.sellhistory.CaseSellHistoryStorage
import invest.data.database.table.sellhistory.CaseSellHistoryTable
import invest.domain.model.CasePriceData
import org.jetbrains.exposed.sql.`java-time`.day
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DailySellHistoryTableRepositoryTest{

    @Test
    fun jaja(){
        val output = getMonthlyCasePriceData(1)
        assertEquals(1,output)
    }


    private fun getMonthlyCasePriceData(id: Int): CasePriceData {
        val list = mutableListOf<Double>()
        var case = CasePriceData("", emptyList())
        val query = CaseSellHistoryStorage.getPriceListQuery()
        transaction {
            query.forEach {
                val caseId = it[CaseSellHistoryTable.caseId]
                val day = it[CaseSellHistoryTable.date.day()]
                println(day)

                if (caseId == id && day == 13) {
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
}