package com.group.libraryapp

import com.group.libraryapp.calculator.Calculator
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JunitCaculatorTest {

    @Test
    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        assertThat(calculator.number).isEqualTo(2)
    }

    @Test
    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        assertThat(calculator.number).isEqualTo(15)
    }

    @Test
    fun dividenTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.dividen(2)

        // then
        assertThat(calculator.number).isEqualTo(2)
    }

    @Test
    fun dividenExceptionTest() {
        // given
        val calculator = Calculator(5)

        // when
        assertThrows<IllegalArgumentException> {
            calculator.dividen(0)
        }.apply {
            assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
        }
    }

}