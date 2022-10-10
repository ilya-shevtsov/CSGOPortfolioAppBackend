package overview.data.entities

import org.jetbrains.exposed.sql.ResultRow
import overview.data.CaseTable

object CaseDboMapper {
    fun map(row: ResultRow): CaseDbo {
        return CaseDbo(
            id = row[CaseTable.id],
            caseAccess = row[CaseTable.caseAccess],
            name = row[CaseTable.name],
            releaseDate = row[CaseTable.releaseDate],
            dropStatus = row[CaseTable.dropStatus],
            lowestPrice = row[CaseTable.lowestPrice],
            volume = row[CaseTable.volume],
            medianPrice = row[CaseTable.medianPrice],
            imageUrl = row[CaseTable.imageUrl],
            description = row[CaseTable.description]
        )
    }
}