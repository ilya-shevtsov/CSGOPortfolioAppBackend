package data.model.caseDbo

import data.database.CaseDatabase
import org.jetbrains.exposed.sql.ResultRow

object CaseDboMapper {
    fun map(row: ResultRow): CaseDbo {
        return CaseDbo(
            id = row[CaseDatabase.id],
            caseAccess = row[CaseDatabase.caseAccess],
            name = row[CaseDatabase.name],
            releaseDate = row[CaseDatabase.releaseDate],
            dropStatus = row[CaseDatabase.dropStatus],
            lowestPrice = row[CaseDatabase.lowestPrice],
            volume = row[CaseDatabase.volume],
            medianPrice = row[CaseDatabase.medianPrice],
            imageUrl = row[CaseDatabase.imageUrl],
            description = row[CaseDatabase.description]
        )
    }
}