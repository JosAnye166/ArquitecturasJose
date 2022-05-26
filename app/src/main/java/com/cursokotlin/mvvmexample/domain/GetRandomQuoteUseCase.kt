package com.joseangel.arquitectura.domain

import com.joseangel.arquitectura.data.QuoteRepository
import com.joseangel.arquitectura.data.model.QuoteModel
import com.joseangel.arquitectura.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}