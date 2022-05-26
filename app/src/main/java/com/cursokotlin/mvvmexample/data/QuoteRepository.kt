package com.joseangel.arquitectura.data

import com.joseangel.arquitectura.data.database.dao.QuoteDao
import com.joseangel.arquitectura.data.database.entities.QuoteEntity
import com.joseangel.arquitectura.data.model.QuoteModel
import com.joseangel.arquitectura.data.network.QuoteService
import com.joseangel.arquitectura.domain.model.Quote
import com.joseangel.arquitectura.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}