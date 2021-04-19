package invest

import invest.domain.DailySellData
import invest.domain.InvestDataResponse

class InvestRepository {

    val investDataResponse = InvestDataResponse(
        success = true,
        pricePrefix = "",
        priceSuffix = "pуб.",
        prices = listOf(
            DailySellData(
                date = "Feb 16 2018 01: +0",
                price = 678.837,
                volume = "58774"
            )
        )
    )
}


