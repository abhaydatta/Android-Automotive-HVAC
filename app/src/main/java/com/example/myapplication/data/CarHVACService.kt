package com.example.myapplication.data

import android.content.Context

class CarHVACService(context: Context) {
    private var car: Car? = null
    private var hvacManager: CarHvacManager? = null
    private var callback: ((Int) -> Unit)? = null

    init {
        car = Car.createCar(context) {
            hvacManager = it?.getCarManager(Car.HVAC_SERVICE) as? CarHvacManager
            hvacManager?.registerCallback(object : CarHvacManager.CarHvacEventCallback {
                override fun onChangeEvent(value: CarPropertyValue<*>) {
                    if (value.propertyId == CarHvacManager.ID_FAN_SPEED) {
                        val speed = value.value as Int
                        callback?.invoke(speed)
                    }
                }

                override fun onErrorEvent(propId: Int, zone: Int) {
                    // handle error
                }
            })
        }
    }

    fun setFanSpeedListener(listener: (Int) -> Unit) {
        this.callback = listener
    }
}