package invest.data.database.repository

import data.database.CaseTable
import data.model.case.CaseDboMapper
import domain.model.case.CaseDto
import domain.model.case.CaseDtoMapper
import invest.data.database.table.sellhistory.CaseSellHistoryStorage.insertToCaseSellHistoryTable
import invest.data.database.table.sellhistory.CaseSellHistoryTable
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDboMapper
import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.SQLException
import java.time.ZoneOffset

class DailySellHistoryTableRepository {


    fun haha(idList: List<Int>): List<CasePrices> {
        val list = mutableListOf<CasePrices>()
        idList.map { id ->
            val casePrice = getPriceList(id)
            list.add(casePrice)
        }
        return list
    }


    data class CasePrices(
        val name: String,
        val priceList: List<Double>
    )

    fun getPriceList(id: Int): CasePrices {
        val query = buildMyQuery()
        val list = mutableListOf<Double>()
        var case = CasePrices("", emptyList())

        query.forEach {
            if (it[CaseSellHistoryTable.caseId] == id) {
                list.add(it[CaseSellHistoryTable.price])
                case = CasePrices(
                    name = it[CaseSellHistoryTable.name],
                    priceList = list
                )
            }

        }
        return case
    }

    private fun buildMyQuery(): Query {
        return CaseSellHistoryTable
            .slice(
                CaseSellHistoryTable.name,
                CaseSellHistoryTable.caseId,
                CaseSellHistoryTable.date,
                CaseSellHistoryTable.price,
            ).selectAll()
            .groupBy(
                CaseSellHistoryTable.caseId,
                CaseSellHistoryTable.date
            )
            .orderBy(CaseSellHistoryTable.date to SortOrder.ASC)
    }

    fun insertData() {
        val dailySellHistoryDboList = getDailySellHistoryDboList("resources/caseJson")
        for (dailySellHistoryDbo in dailySellHistoryDboList) {
            try {
                insertToCaseSellHistoryTable(dailySellHistoryDbo)
            } catch (e: SQLException) {
                continue
            }
        }

    }

    private fun getDailySellHistoryDboList(resourcePath: String): MutableList<DailySellHistoryDbo> {
        val dailySellHistoryDboList = mutableListOf<DailySellHistoryDbo>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            val caseName = handleFileName(filePath)
            getDailySellHistoryFromJson(filePath).map { dailySellHistory ->
                val dailySellHistoryDbo = DailySellHistoryDboMapper
                    .map(caseName, dailySellHistory)
                dailySellHistoryDboList.add(dailySellHistoryDbo)
            }
        }
        return dailySellHistoryDboList
    }

    private fun getDailySellHistoryFromJson(jsonPath: String): List<DailySellHistory> {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val dailySellHistoryData = SellHistoryMapper.map(parsedJson)
        return getDailySellHistoryList(dailySellHistoryData)
    }


    private fun getDailySellHistoryList(dailySellHistoryData: List<DailySellHistory>): MutableList<DailySellHistory> {
        val dailySellHistoryList = mutableListOf<DailySellHistory>()
        dailySellHistoryData.map { day ->
            if (day.date.atZone(ZoneOffset.UTC).hour == 1) {
                dailySellHistoryList.add(day)
            }
        }
        return dailySellHistoryList
    }

    private fun handleFileName(filePath: String): String {
        return filePath
            .replace(".json", "")
            .replace("caseJson/", "")
            .replace("/", "")
    }

    private fun handleFilePath(file: File): String {
        val filePath = file.toString()
            .replace("resources\\", "")
            .replace("""\""", "/")
        return "/$filePath"
    }

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}
