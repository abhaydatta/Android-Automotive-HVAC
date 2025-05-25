package com.example.myapplication.repository

import com.example.myapplication.data.HVIResponseModel
import kotlinx.coroutines.flow.Flow

interface HvacRepository {
    fun getFanSpeed():Flow<HVIResponseModel>
}