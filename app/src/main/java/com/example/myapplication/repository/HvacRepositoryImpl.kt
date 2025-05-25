package com.example.myapplication.repository

import com.example.myapplication.data.CarHVACService
import com.example.myapplication.data.HVIResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HvacRepositoryImpl @Inject constructor(
) : HvacRepository {

    private val carHvacService = CarHVACService(context)
    private var fanSpeed:Int = 0
    override fun getFanSpeed(): Flow<HVIResponseModel> {
        // we have the spped
        carHvacService.setFanSpeedListener { speed ->
            fanSpeed = speed
        }
        return flowOf( HVIResponseModel(fanSpeed))
    }

}
