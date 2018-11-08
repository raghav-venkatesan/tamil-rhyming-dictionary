package ca.havensoft.tamilrhymingdictionary.di.modules

import android.content.Context
import ca.havensoft.tamilrhymingdictionary.application.appContext
import ca.havensoft.tamilrhymingdictionary.repository.WordListService
import ca.havensoft.tamilrhymingdictionary.R
import ca.havensoft.tamilrhymingdictionary.util.CSVFile
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideService(context: Context): WordListService {

        val inputStream  = context.resources.openRawResource(R.raw.tamil_word_list)
        return WordListService(CSVFile(inputStream).read()!!)
    }

}