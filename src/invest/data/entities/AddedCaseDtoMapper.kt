package invest.data.entities

import invest.data.CommonRepository

object AddedCaseDtoMapper {

    val commonRepository = CommonRepository()

    //PlaceHolder for overallValue and profitLoss

    private fun makeImageUri(caseName: String): String {
        val newName = caseName
            .replace(" ", "%20")
            .replace(":", "%3A")
        return "https://api.steamapis.com/image/item/730/$newName"
    }

    fun map(addedCaseDto: AddedCaseDto): PortfolioItemDbo {
        return PortfolioItemDbo(
            caseId = commonRepository.assignId(addedCaseDto.name),
            name = addedCaseDto.name,
            amount = addedCaseDto.amount,
            purchasePrice = addedCaseDto.purchasePrice,
            overallValue = addedCaseDto.amount * addedCaseDto.purchasePrice,
            profitLoss = 0.0,
            imageUrl = makeImageUri(addedCaseDto.name)
        )
    }
}