package invest

import invest.domain.DailySellHistory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SellHistoryRepositoryTest {

    val sellHistoryRepository = SellHistoryRepository()

    @Test
    fun haha() {
        val haha = checkSharpRatio("resources/hh",30)
        Assertions.assertEquals("Case is currently in decline", haha)
    }

    fun checkSharpRatio(resourcePath:String,period: Int):List<String> {
        val errorMessage = "Case price is currently in decline"
        val outputList = mutableListOf<String>()
        val haha = File(resourcePath).walk().toMutableList().drop(1)

        haha.forEach {file ->
            val filePath = file.toString()
                .replace("resources\\","")
                .replace("""\""","/")
            val filePathNew = "/$filePath"
            val fileName = filePath
                .replace(".json","")
                .replace("caseJson/","")
            val response = sellHistoryRepository.calculateSharpRatioFromJSON(filePathNew,period)
            if (response.isNaN()){
                outputList.add("$fileName Sharp Ratio is: $errorMessage")
            }else{
                outputList.add("$fileName Sharp Ratio is: $response")
            }
        }
        return outputList
    }
}
