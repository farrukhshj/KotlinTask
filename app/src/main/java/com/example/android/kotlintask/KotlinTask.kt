package com.example.android.kotlintask

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.File

data class OrderData(
    @SerializedName("order") var order: ArrayList<Order> = arrayListOf()
)

data class Order(
    @SerializedName("type") var type: String? = null,
    @SerializedName("size") var size: String? = null,
    @SerializedName("toppings") var toppings: ArrayList<String> = arrayListOf(),
    @SerializedName("sauce") var sauce: ArrayList<String> = arrayListOf()
)

fun main() {
    val data = getOrderData()
    data.order.forEach {
        when(it.size){
            "small" -> println("Price for small pizza = 4€")
            "medium" -> println("Price for medium pizza = 8€")
            "large" -> println("Price for large pizza = 15€")
            else -> println("That's weird! we don't seem to have a price for that pizza")
        }
    }
}

fun getOrderData(): OrderData {
    val jsonString = File("app/src/main/java/com/example/android/kotlintask/order.json").readText()
    return Gson().fromJson(jsonString,OrderData::class.java)
}
