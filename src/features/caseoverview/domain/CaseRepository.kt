package features.caseoverview.domain

import features.caseoverview.data.entities.CaseDbo
import features.caseoverview.data.entities.CaseDto
import features.caseoverview.domain.entities.MarketOverview
import kotlinx.coroutines.flow.Flow

interface CaseRepository {

    suspend fun getMarketOverview(caseName: String, currency: Int): Flow<MarketOverview>

    fun getCaseData(): List<CaseDto>

    fun getCaseList(): List<CaseDbo>

    fun createDatabase()

    fun insertInitialDataCaseOverview()

    fun saveMarketOverview(caseId: Int, marketOverviewDto: MarketOverview)
}