package domain.repository

import model.CaseDataResponseMapper
import model.SimpleCaseDto
import data.api.ApiTools
import data.database.CaseDbo
import domain.model.CaseDto

class Repository {

    fun toCaseDto(caseDbo: CaseDbo): CaseDto {
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

    suspend fun getSimpleCaseDto(caseName: String): SimpleCaseDto {
        val simpleResponse = ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
        return CaseDataResponseMapper.map(simpleResponse, caseName)
    }

//    fun getCaseDto(
//        simpleCaseDto: SimpleCaseDto,
//        releaseDate: String,
//        dropStatus: String,
//        imageUrl: String,
//        description: String
//    ): CaseDto {
//        return CaseDto(
//            name = simpleCaseDto.name,
//            releaseDate = releaseDate,
//            dropStatus = dropStatus,
//            lowestPrice = simpleCaseDto.lowestPrice,
//            volume = simpleCaseDto.volume,
//            medianPrice = simpleCaseDto.medianPrice,
//            imageUrl = imageUrl,
//            description = description
//        )
//    }
}

