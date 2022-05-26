package com.joseangel.arquitectura.domain.model

import com.joseangel.arquitectura.data.database.entities.QuoteEntity
import com.joseangel.arquitectura.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)