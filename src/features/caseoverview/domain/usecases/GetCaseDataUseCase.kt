package features.caseoverview.domain.usecases

import features.caseoverview.data.entities.CaseDto
import features.caseoverview.domain.CaseRepository
import javax.inject.Inject

class GetCaseDataUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke(): List<CaseDto> {
        return caseRepository.getCaseData()
    }
}