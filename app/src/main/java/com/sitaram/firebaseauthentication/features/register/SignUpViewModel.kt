package com.sitaram.firebaseauthentication.features.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitaram.firebaseauthentication.features.data.AuthRepository
import com.sitaram.firebaseauthentication.features.login.LoginState
import com.sitaram.firebaseauthentication.features.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: AuthRepository): ViewModel() {

    private val _signUpState = Channel<LoginState>()
    val signUpState = _signUpState.receiveAsFlow()

    fun registerUser(email: String, password: String) = viewModelScope.launch {

        repository.loginUser(email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signUpState.send(LoginState(isSuccess = "Login successful"))
                }

                is Resource.Loading -> {
                    _signUpState.send(LoginState(isLoading = true))
                }

                is Resource.Error -> {
                    _signUpState.send(LoginState(isSuccess = result.message))
                }
            }
        }
    }
}