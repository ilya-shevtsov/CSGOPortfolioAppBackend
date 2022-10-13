package features.caseoverview.domain.usecases

import features.caseoverview.data.entities.CaseDbo
import features.caseoverview.domain.CaseRepository
import javax.inject.Inject

class GetCaseListUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke(): List<CaseDbo> {
        return caseRepository.getStoredCaseList()
    }
}