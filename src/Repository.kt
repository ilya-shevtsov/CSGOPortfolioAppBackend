package com.ilya.shevtsov.casewatcher

import com.ilya.shevtsov.casewatcher.Model.CaseDataResponse
import com.ilya.shevtsov.casewatcher.Model.CaseDataResponseMapper
import com.ilya.shevtsov.casewatcher.Model.CaseDto
import com.ilya.shevtsov.casewatcher.Model.SimpleCaseDto
import com.ilya.shevtsov.casewatcher.data.api.ApiTools

class Repository {

    private val caseNameList = listOf(
        "Chroma%20Case",
        "Chroma%202%20Case",
        "Chroma%203%20Case",
        "Clutch%20Case",
        "CS%3AGO%20Weapon%20Case",
        "CS%3AGO%20Weapon%20Case%202",
        "CS%3AGO%20Weapon%20Case%203",
        "CS20%20Case",
        "Danger%20Zone%20Case",
        "eSports%202013%20Case",
        "eSports%202013%20Winter%20Case",
        "eSports%202014%20Summer%20Case",
        "Falchion%20Case",
        "Fracture%20Case",
        "Gamma%202%20Case",
        "Gamma%20Case",
        "Glove%20Case",
        "Horizon%20Case",
        "Huntsman%20Weapon%20Case",
        "Operation%20Bravo%20Case",
        "Operation%20Breakout%20Weapon%20Case",
        "Operation%20Broken%20Fang%20Case",
        "Operation%20Hydra%20Case",
        "Operation%20Phoenix%20Weapon%20Case",
        "Operation%20Vanguard%20Weapon%20Case",
        "Operation%20Wildfire%20Case",
        "Prisma%20Case",
        "Prisma%202%20Case",
        "Revolver%20Case",
        "Shadow%20Case",
        "Shattered%20Web%20Case",
        "Spectrum%202%20Case",
        "Spectrum%20Case",
        "Winter%20Offensive%20Weapon%20Case"
    )


    val listOfOneCaseDto = listOf(
        CaseDto(
            "Chroma Case",
            "08.01.2015",
            "Inactive (Rare)",
            64.23,
            3803,
            62.54,
            "https://api.steamapis.com/image/item/730/Chroma%20Case",
            "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."
        )
    )

    suspend fun getSimpleCaseDto(caseName: String): SimpleCaseDto {
        val simpleResponse = ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
        return CaseDataResponseMapper.map(simpleResponse, caseName)
    }

    fun getCaseDto(
        simpleCaseDto: SimpleCaseDto,
        releaseDate: String,
        dropStatus: String,
        imageUrl: String,
        description: String
    ): CaseDto {
        return CaseDto(
            name = simpleCaseDto.name,
            releaseDate = releaseDate,
            dropStatus = dropStatus,
            lowestPrice = simpleCaseDto.lowestPrice,
            volume = simpleCaseDto.volume,
            medianPrice = simpleCaseDto.medianPrice,
            imageUrl = imageUrl,
            description = description
        )
    }
}

