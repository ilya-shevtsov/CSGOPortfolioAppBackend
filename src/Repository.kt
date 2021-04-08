package com.ilya.shevtsov.casewatcher

import com.ilya.shevtsov.casewatcher.Model.CaseDataResponseMapper
import com.ilya.shevtsov.casewatcher.Model.SimpleCaseDto
import com.ilya.shevtsov.casewatcher.data.api.ApiTools

class Repository {

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

