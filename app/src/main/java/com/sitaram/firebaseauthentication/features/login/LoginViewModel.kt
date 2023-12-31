package com.sitaram.firebaseauthentication.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitaram.firebaseauthentication.features.data.AuthRepository
import com.sitaram.firebaseauthentication.features.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository): ViewModel() {

    private val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _loginState.send(LoginState(isSuccess = "Login successful"))
                }

                is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading = true))
                }

                is Resource.Error -> {
                    _loginState.send(LoginState(isSuccess = result.message))
                }
            }
        }
    }
}