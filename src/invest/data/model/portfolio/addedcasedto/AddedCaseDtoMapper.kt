package invest.data.model.portfolio.addedcasedto

import invest.data.model.portfolio.dbo.PortfolioItemDbo

object AddedCaseDtoMapper {

    //PlaceHolder for overallValue and profitLoss

    fun makeImageUri(caseName: String): String {
        val newName = caseName
            .replace(" ", "%20")
            .replace(":", "%3A")
        return "https://api.steamapis.com/image/item/730/$newName"
    }

    fun map(addedCaseDto: AddedCaseDto): PortfolioItemDbo {
        return PortfolioItemDbo(
            name =addedCaseDto.name,
            amount =addedCaseDto.amount,
            purchasePrice =addedCaseDto.purchasePrice,
            overallValue =0.0,
            profitLoss =0.0,
            imageUrl = makeImageUri(addedCaseDto.name)
        )
    }
}