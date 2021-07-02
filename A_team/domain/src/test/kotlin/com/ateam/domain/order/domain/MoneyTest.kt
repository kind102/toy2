package com.ateam.domain.order.domain

import com.ateam.domain.order.domain.Money
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MoneyTest{

    @CsvSource(
        value = ["0.0","1.0"]
    )
    @ParameterizedTest
    fun `money는 0이상 이다`(value: Double){
        assertDoesNotThrow { Money(value) }
    }

    @CsvSource(
        value = ["-1.0","-2.0"]
    )
    @ParameterizedTest
    fun `money는 0미만 이면 예외 발생`(value: Double){
        assertThrows<IllegalArgumentException>{
            Money(value)
        }
    }
}
