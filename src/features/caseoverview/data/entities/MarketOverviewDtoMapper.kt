package features.caseoverview.data.entities

import features.caseoverview.domain.entities.MarketOverview

object MarketOverviewDtoMapper {

    fun map(
        marketOverviewDto: MarketOverviewDto,
        caseName: String,
    ): MarketOverview {

        val newCaseName = caseName
            .replace("%20", " ")
            .replace("%3A", ":")

        val newLowestPrice = marketOverviewDto.lowestPrice
            .replace(" pуб.", "")
            .replace("$", "")
            .replace(",", ".")
            .toDouble()

        val newVolume = marketOverviewDto.volume
            .replace(",", "")
            .toInt()

        val newMedianPrice = marketOverviewDto.medianPrice
            .replace(" pуб.", "")
            .replace("$", "")
            .replace(",", ".")
            .toDouble()

        return MarketOverview(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
        )
    }
}