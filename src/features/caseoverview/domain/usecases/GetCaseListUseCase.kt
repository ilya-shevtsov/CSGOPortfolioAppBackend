package features.caseoverview.domain.usecases

import features.caseoverview.data.entities.CaseDbo
import features.caseoverview.data.CaseRepositoryImpl
import features.caseoverview.domain.CaseRepository
import features.caseportfolio.domain.PortfolioRepository
import javax.inject.Inject

class GetCaseListUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke(): List<CaseDbo> {
        return caseRepository.getCaseList()
    }
}