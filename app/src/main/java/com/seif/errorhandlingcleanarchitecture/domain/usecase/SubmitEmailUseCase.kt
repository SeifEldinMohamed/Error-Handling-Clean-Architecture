package com.seif.errorhandlingcleanarchitecture.domain.usecase

import com.seif.errorhandlingcleanarchitecture.R
import com.seif.errorhandlingcleanarchitecture.data.repository.RepositoryImp
import com.seif.errorhandlingcleanarchitecture.util.Resource
import com.seif.errorhandlingcleanarchitecture.util.UiText

class SubmitEmailUseCase(
    private val repositoryImp: RepositoryImp = RepositoryImp()
) {
   suspend operator fun invoke(email:String): Resource<Unit> {
        if (!email.contains('@')){
            return Resource.Error(UiText.StringResource(R.string.error_invalid_email))
        }
        return repositoryImp.submitEmail(email)
    }
 //   class InvalidEmailException: Exception("that is not valid email") // another way instead of Resource class
}