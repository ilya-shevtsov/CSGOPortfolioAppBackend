package core.dependencyInjection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(dependencyInjection: DependencyInjection)

}