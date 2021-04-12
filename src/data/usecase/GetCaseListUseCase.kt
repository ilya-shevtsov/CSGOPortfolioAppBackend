package data.usecase

import data.model.caseDbo.CaseDbo
import data.repository.DatabaseRepository

class GetCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {

    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}