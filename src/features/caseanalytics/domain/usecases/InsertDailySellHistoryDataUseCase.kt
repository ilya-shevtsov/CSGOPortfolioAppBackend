package features.caseanalytics.domain.usecases

import features.caseanalytics.domain.SellHistoryRepository
import javax.inject.Inject

class InsertDailySellHistoryDataUseCase @Inject constructor(
    private val sellHistoryRepository: SellHistoryRepository
) {
    operator fun invoke(){
        sellHistoryRepository.insertDailySellHistoryData()
    }
}