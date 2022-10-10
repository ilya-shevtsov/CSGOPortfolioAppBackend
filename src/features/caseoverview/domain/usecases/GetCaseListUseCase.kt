package features.caseoverview.domain.usecases

import features.caseoverview.data.entities.CaseDbo
import features.caseoverview.data.DatabaseRepository

class GetCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}