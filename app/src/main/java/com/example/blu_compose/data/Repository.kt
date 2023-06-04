package com.example.blu_compose.data

import com.example.blu_compose.model.CampusDataSource
import com.example.blu_compose.model.OrderCampus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val orderCampus = mutableListOf<OrderCampus>()

    init {
        if (orderCampus.isEmpty()) {
            CampusDataSource.campusData.forEach {
                orderCampus.add(OrderCampus(it, 0))
            }
        }
    }

    fun getAllCampus(): Flow<List<OrderCampus>> {
        return flowOf(orderCampus)
    }

    fun getOrderCampusById(campusId: Long): OrderCampus {
        return orderCampus.first {
            it.campus.id == campusId
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository =
            instance ?: synchronized(this) {
                Repository().apply {
                    instance = this
                }
            }
    }
}