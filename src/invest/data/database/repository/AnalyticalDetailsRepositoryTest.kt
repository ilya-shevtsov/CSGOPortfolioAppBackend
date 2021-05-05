package invest.data.database.repository

import invest.data.model.analyticaldetails.dbo.AnalyticalDetailsDbo
import invest.data.model.analyticaldetails.dbo.AnalyticalDetailsMapper
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AnalyticalDetailsRepositoryTest{

    val analyticalDetailsRepository = AnalyticalDetailsRepository()

    @Test
    fun test(){
        Database.connect("jdbc:h2:./caseDatabase", "org.h2.Driver")
        val analyticalDetailsDboList = mutableListOf<AnalyticalDetailsDbo>()
        transaction {
            val outputOne = analyticalDetailsRepository.getMonthlyAnalyticalDetailList()
            val outputTwo = analyticalDetailsRepository.getDailyAnalyticalDetailList()
            val newList =
                outputOne zip outputTwo
            newList.map { pair ->
                analyticalDetailsDboList.add(
                    AnalyticalDetailsMapper.mapToDbo(pair)
                )
            }
            assertEquals("f", analyticalDetailsDboList)
        }
    }
}

