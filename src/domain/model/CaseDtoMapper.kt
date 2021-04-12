package domain.model

import data.database.CaseDbo

object CaseDtoMapper {

    fun map(caseDbo: CaseDbo): CaseDto {
        return CaseDto(
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