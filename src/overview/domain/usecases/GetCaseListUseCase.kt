package overview.domain.usecases

import overview.data.entities.CaseDbo
import overview.data.DatabaseRepository

class GetCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}