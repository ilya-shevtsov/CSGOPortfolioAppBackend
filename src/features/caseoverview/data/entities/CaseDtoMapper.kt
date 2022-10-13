package features.caseoverview.data.entities

import features.caseoverview.domain.entities.Case

object CaseDtoMapper {

    fun map(case: Case): CaseDto {
        return CaseDto(
            name = case.name,
            releaseDate = case.releaseDate,
            dropStatus = case.dropStatus,
            lowestPrice = case.lowestPrice,
            volume = case.volume,
            medianPrice = case.medianPrice,
            imageUrl = case.imageUrl,
            description = case.description
        )
    }
}