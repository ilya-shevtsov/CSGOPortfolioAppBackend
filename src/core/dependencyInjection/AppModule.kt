package core.dependencyInjection

import dagger.Module

@Module(
    includes = [
        DataModule::class
    ]
)
interface AppModule