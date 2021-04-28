package domain.usecase

import data.model.case.CaseDbo
import data.repository.DatabaseRepository

class GetCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}