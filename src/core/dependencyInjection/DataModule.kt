package core.dependencyInjection

import dagger.Binds
import dagger.Module
import features.caseanalytics.data.CaseAnalyticsRepositoryImpl
import features.caseanalytics.domain.CaseAnalyticsRepository
import features.caseoverview.data.CaseRepositoryImpl
import features.caseoverview.domain.CaseRepository
import features.caseportfolio.data.PortfolioRepositoryImpl
import features.caseportfolio.domain.PortfolioRepository
import javax.inject.Singleton


@Module
interface DataModule {

    @Binds
    @Singleton
    fun portfolioRepository(impl: PortfolioRepositoryImpl): PortfolioRepository

    @Binds
    @Singleton
    fun caseRepository (impl: CaseRepositoryImpl): CaseRepository

    @Binds
    @Singleton
    fun caseAnalyticsRepository (impl: CaseAnalyticsRepositoryImpl): CaseAnalyticsRepository
}