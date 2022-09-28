package com.seif.errorhandlingcleanarchitecture.domain.usecase

import com.seif.errorhandlingcleanarchitecture.data.repository.RepositoryImp
import com.seif.errorhandlingcleanarchitecture.util.Resource

class SubmitEmailUseCase(
    private val repositoryImp: RepositoryImp = RepositoryImp()
) {
   suspend operator fun invoke(email:String): Resource<Unit> {
        if (!email.contains('@')){
            return Resource.Error("that is not a valid email")
        }
        return repositoryImp.submitEmail(email)
    }
    class InvalidEmailException: Exception("that is not valid email")
}