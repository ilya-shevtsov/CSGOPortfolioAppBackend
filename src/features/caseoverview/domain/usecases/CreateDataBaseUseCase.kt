package features.caseoverview.domain.usecases

import features.caseoverview.domain.CaseRepository
import javax.inject.Inject

class CreateDataBaseUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke() {
        return caseRepository.createDatabase()
    }
}