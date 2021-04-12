package data.model.caseDataResponse

import data.model.MarketOverviewDto

object CaseDataResponseMapper {

    fun map(
        caseDataResponse: CaseDataResponse,
        caseName: String,
    ): MarketOverviewDto {

        val newCaseName = caseName
            .replace("%20", " ")
            .replace("%3A", ":")

        val newLowestPrice = caseDataResponse.lowestPrice
            .replace(" pуб.", "")
            .replace(",", ".")
            .toDouble()

        val newVolume = caseDataResponse.volume
            .replace(",", "")
            .toInt()

        val newMedianPrice = caseDataResponse.medianPrice
            .replace(" pуб.", "")
            .replace(",", ".")
            .toDouble()

        return MarketOverviewDto(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
        )
    }
}