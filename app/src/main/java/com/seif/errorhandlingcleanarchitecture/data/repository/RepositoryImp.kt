package com.seif.errorhandlingcleanarchitecture.data.repository

import com.seif.errorhandlingcleanarchitecture.domain.repository.Repository
import com.seif.errorhandlingcleanarchitecture.util.Resource
import com.seif.errorhandlingcleanarchitecture.util.UiText
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
                Resource.Error(UiText.DynamicString("Server Error"))
            }
            else {
                Resource.Error(UiText.DynamicString("not Authenticated Error"))
            }
        }
    }
}