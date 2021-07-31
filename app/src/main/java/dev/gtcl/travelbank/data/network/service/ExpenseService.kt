package dev.gtcl.travelbank.data.network.service

import dev.gtcl.travelbank.data.model.ExpenseRemote
import retrofit2.http.GET

interface ExpenseService {

    @GET("v3/178cbbee-c634-4a51-afb8-dcd75c190d29")
    suspend fun getExpenseList(): List<ExpenseRemote>

}