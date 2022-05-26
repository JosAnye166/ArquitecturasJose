package com.joseangel.arquitectura.domain

import com.joseangel.arquitectura.data.QuoteRepository
import com.joseangel.arquitectura.data.database.entities.toDatabase
import com.joseangel.arquitectura.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}