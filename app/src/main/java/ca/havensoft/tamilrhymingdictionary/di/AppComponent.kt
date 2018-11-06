package ca.havensoft.tamilrhymingdictionary.di

import ca.havensoft.tamilrhymingdictionary.di.modules.AppModule
import ca.havensoft.tamilrhymingdictionary.di.modules.RepositoryModule
import ca.havensoft.tamilrhymingdictionary.di.modules.ServiceModule
import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ServiceModule::class, RepositoryModule::class])
interface AppComponent {
    fun injectWordRepo(target: WordListViewModel)
}