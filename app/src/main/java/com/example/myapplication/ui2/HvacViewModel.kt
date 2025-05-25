package com.example.myapplication.ui2

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.HVIResponseModel
import com.example.myapplication.usecase.HvacUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HvacViewModel @Inject constructor(
    private val hvacUseCase: HvacUseCase
):ViewModel() {
    private val _uiState = MutableStateFlow(HVIResponseModel())
    var uiState:StateFlow<HVIResponseModel> = _uiState.asStateFlow()
    private var fanSpeed:MutableLiveData<Int> = MutableLiveData<Int>()

    fun getFanSpeedCar(){
        viewModelScope.launch {
            hvacUseCase.getVehicleFanSpeed().collect{
                fanSpeed.value = it.fanSpeed
                _uiState.update { model ->
                    model.copy(fanSpeed = it.fanSpeed)
                }
            }
        }
    }
}