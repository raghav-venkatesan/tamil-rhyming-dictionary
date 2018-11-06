package ca.havensoft.tamilrhymingdictionary.util

import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import java.io.*


class CSVFile(private val inputStream: InputStream) {
    fun read(): List<Array<String>>? {
        var fileReader: BufferedReader? = null
        var csvReader: CSVReader? = null

        try {
            fileReader = BufferedReader(InputStreamReader(inputStream))
            csvReader = CSVReaderBuilder(fileReader).withSkipLines(1).build()

            return csvReader.readAll()
        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close()
                csvReader!!.close()
            } catch (e: IOException) {
                println("Closing fileReader/csvParser Error!")
                e.printStackTrace()
            }
        }

        return null
    }
}