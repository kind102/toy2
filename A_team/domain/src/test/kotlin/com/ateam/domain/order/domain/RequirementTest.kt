package com.ateam.domain.order.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class RequirementTest{

    @Test
    fun `사장님 요청사항이 60자 초과시 예외 발생`(){
        val str = (1..61).joinToString(separator=""){"a"};
        assertThrows<IllegalArgumentException>(message = "invalid owner requirement"){
            Requirement(
                riderRequirement = "abc",
                ownerRequirement = str
            )
        }
    }

    @Test
    fun `라이더 요청사항이 60자 초과시 예외 발생`(){
        val str = (1..61).joinToString(separator="",transform={ "a" });
        assertThrows<IllegalArgumentException>(message = "invalid rider requirement"){
            Requirement(
                riderRequirement = str,
                ownerRequirement = "abc"
            )
        }
    }

    @Test
    fun `사장님, 라이더 요청사항`(){
        assertDoesNotThrow {
            Requirement(
                ownerRequirement = "사장님 요청사항",
                riderRequirement = "라이더 요청사항"
            )
        }
    }
}
