package ca.havensoft.tamilrhymingdictionary.di.modules

import android.content.Context
import ca.havensoft.tamilrhymingdictionary.application.appContext
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(): Context = appContext()
}