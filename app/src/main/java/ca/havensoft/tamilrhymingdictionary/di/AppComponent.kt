package ca.havensoft.tamilrhymingdictionary.di

import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, RepositoryModule::class])
interface AppComponent {
    fun injectWordRepo(target: WordListViewModel)
}