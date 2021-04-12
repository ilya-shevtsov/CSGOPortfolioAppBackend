package data.usecase

import data.database.CaseDbo
import data.repository.DatabaseRepository

class getCaseListUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun getCaseList(): List<CaseDbo> {
        return databaseRepository.getCaseList()
    }
}