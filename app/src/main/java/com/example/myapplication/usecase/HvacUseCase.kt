package com.example.myapplication.usecase

import com.example.myapplication.repository.HvacRepository

class HvacUseCase @Inject constructor(
    private val repository: HvacRepository
) {
    fun getVehicleFanSpeed() = repository.getFanSpeed()
}