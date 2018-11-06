package ca.havensoft.tamilrhymingdictionary.di.modules

import ca.havensoft.tamilrhymingdictionary.repository.WordListService
import ca.havensoft.tamilrhymingdictionary.repository.WordRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service: WordListService) = WordRepository(service)

}