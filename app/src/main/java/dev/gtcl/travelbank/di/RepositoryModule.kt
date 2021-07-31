package dev.gtcl.travelbank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gtcl.travelbank.repository.ExpenseRepositoryImpl
import dev.gtcl.travelbank.repository.ExpenseRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun expenseRepositoryProvider(
        expenseRepositoryImpl: ExpenseRepositoryImpl
    ): ExpenseRepository

}