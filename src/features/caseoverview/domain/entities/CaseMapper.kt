package features.caseoverview.domain.entities

import features.caseoverview.data.entities.CaseDbo

object CaseMapper {

    fun map(caseDbo: CaseDbo): Case {
        return Case(
            name = caseDbo.name,
            releaseDate = caseDbo.releaseDate,
            dropStatus = caseDbo.dropStatus,
            lowestPrice = caseDbo.lowestPrice,
            volume = caseDbo.volume,
            medianPrice = caseDbo.medianPrice,
            imageUrl = caseDbo.imageUrl,
            description = caseDbo.description
        )
    }
}