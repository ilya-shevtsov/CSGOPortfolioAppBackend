package core.dependencyInjection

import features.caseoverview.domain.usecases.*
import features.caseportfolio.domain.usecases.*
import javax.inject.Inject

class DependencyInjection {
    private val appComponent: AppComponent = DaggerAppComponent.create()

    @Inject
    lateinit var getPortfolioDataUseCase: GetPortfolioDataUseCase

    @Inject
    lateinit var updatePortfolioUseCase: UpdatePortfolioUseCase

    @Inject
    lateinit var updateInfoUseCase: UpdateInfoUseCase

    @Inject
    lateinit var getCaseDataUseCase: GetCaseDataUseCase

    @Inject
    lateinit var createDataBaseUseCase: CreateDataBaseUseCase

    @Inject
    lateinit var insertInitialDataUseCase: InsertInitialDataUseCase

    init {
        appComponent.inject(this)
    }
}