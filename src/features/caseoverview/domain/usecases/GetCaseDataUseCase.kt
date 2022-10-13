package features.caseoverview.domain.usecases

import features.caseoverview.domain.CaseRepository
import features.caseoverview.domain.entities.Case
import javax.inject.Inject

class GetCaseDataUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke(): List<Case> {
        return caseRepository.getCaseData()
    }
}