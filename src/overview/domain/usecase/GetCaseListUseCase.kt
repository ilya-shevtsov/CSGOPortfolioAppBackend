package overview.domain.usecase

import overview.data.model.case.CaseDbo
import overview.data.repository.DatabaseRepository

class GetCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}