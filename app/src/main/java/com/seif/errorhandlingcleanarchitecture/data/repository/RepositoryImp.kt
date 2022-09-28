package com.seif.errorhandlingcleanarchitecture.data.repository

import com.seif.errorhandlingcleanarchitecture.domain.repository.Repository
import com.seif.errorhandlingcleanarchitecture.util.Resource
import kotlinx.coroutines.delay
import kotlin.random.Random

class RepositoryImp: Repository {
    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if(Random.nextBoolean()) {
             Resource.Success(Unit)
        }
        else {
            if(Random.nextBoolean()) {
                Resource.Error("Server Error")
            }
            else {
                Resource.Error("not Authenticated Error")
            }
        }
    }
}