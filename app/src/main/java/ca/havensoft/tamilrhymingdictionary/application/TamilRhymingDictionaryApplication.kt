package ca.havensoft.tamilrhymingdictionary.application

import android.app.Application
import ca.havensoft.tamilrhymingdictionary.di.AppComponent
import ca.havensoft.tamilrhymingdictionary.di.DaggerAppComponent

class TamilRhymingDictionaryApplication : Application() {

    companion object {
        lateinit var instance: TamilRhymingDictionaryApplication

        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}