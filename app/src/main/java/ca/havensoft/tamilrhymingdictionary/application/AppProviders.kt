package ca.havensoft.tamilrhymingdictionary.application

import ca.havensoft.tamilrhymingdictionary.viewmodels.WordListViewModel

fun component() = TamilRhymingDictionaryApplication.component

fun appContext() = TamilRhymingDictionaryApplication.instance

fun injectWordRepo(target: WordListViewModel) = component().injectWordRepo(target)