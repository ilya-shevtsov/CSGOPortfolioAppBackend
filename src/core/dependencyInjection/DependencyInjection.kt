package core.dependencyInjection

import features.caseportfolio.domain.usecases.GetPortfolioDataUseCase
import javax.inject.Inject

class DependencyInjection {
    private val appComponent: AppComponent = DaggerAppComponent.create()

    @Inject
    lateinit var getPortfolioDataUseCase: GetPortfolioDataUseCase


    init {
        appComponent.inject(this)
    }
}