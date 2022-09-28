package com.seif.errorhandlingcleanarchitecture.domain.repository

import com.seif.errorhandlingcleanarchitecture.util.Resource

interface Repository {
    suspend fun submitEmail(email:String): Resource<Unit>
}