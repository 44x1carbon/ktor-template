package lib.validation.rules.any

import lib.validation.Verifiable
import lib.validation.rules.Rule
import org.junit.Test
import kotlin.test.assertEquals

class BetweenTest {
    // Int
    class IntTestData(val age: Int): Verifiable {
        override val rules: Map<String, List<Rule<*>>>
            get() = mapOf(
                    "age" to listOf(
                            Between<Int>(10..20)
                    )
            )
    }
    @Test fun IntOk() {
        assertEquals(IntTestData(10).valid().get("age")?.size, 0)
        assertEquals(IntTestData(20).valid().get("age")?.size, 0)
        assertEquals(IntTestData(15).valid().get("age")?.size, 0)
    }
    @Test fun IntNg() {
        assertEquals(IntTestData(-10).valid().get("age")?.size, 1)
        assertEquals(IntTestData(9).valid().get("age")?.size, 1)
        assertEquals(IntTestData(21).valid().get("age")?.size, 1)
        assertEquals(IntTestData(100).valid().get("age")?.size, 1)
    }

    // Double
    class DoubleTestData(val age: Double): Verifiable {
        override val rules: Map<String, List<Rule<*>>>
            get() = mapOf(
                    "age" to listOf(
                            Between<Double>(10..20)
                    )
            )
    }
    @Test fun DoubleOk() {
        assertEquals(DoubleTestData(10.0).valid().get("age")?.size, 0)
        assertEquals(DoubleTestData(20.0).valid().get("age")?.size, 0)
        assertEquals(DoubleTestData(20.9).valid().get("age")?.size, 0)
        assertEquals(DoubleTestData(15.5).valid().get("age")?.size, 0)
    }
    @Test fun DoubleNg() {
        assertEquals(DoubleTestData(-10.0).valid().get("age")?.size, 1)
        assertEquals(DoubleTestData(9.9).valid().get("age")?.size, 1)
        assertEquals(DoubleTestData(21.1).valid().get("age")?.size, 1)
        assertEquals(DoubleTestData(100.0).valid().get("age")?.size, 1)
    }

    // Float
    class FloatTestData(val age: Float): Verifiable {
        override val rules: Map<String, List<Rule<*>>>
            get() = mapOf(
                    "age" to listOf(
                            Between<Float>(10..20)
                    )
            )
    }
    @Test fun FloatOk() {
        assertEquals(FloatTestData(10.0f).valid().get("age")?.size, 0)
        assertEquals(FloatTestData(20.0f).valid().get("age")?.size, 0)
        assertEquals(FloatTestData(20.9f).valid().get("age")?.size, 0)
        assertEquals(FloatTestData(15.5f).valid().get("age")?.size, 0)
    }
    @Test fun FloatNg() {
        assertEquals(FloatTestData(-10.0f).valid().get("age")?.size, 1)
        assertEquals(FloatTestData(9.9f).valid().get("age")?.size, 1)
        assertEquals(FloatTestData(21.1f).valid().get("age")?.size, 1)
        assertEquals(FloatTestData(100.0f).valid().get("age")?.size, 1)
    }

    // String
    class StringTestData(val name: String): Verifiable {
        override val rules: Map<String, List<Rule<*>>>
            get() = mapOf(
                    "name" to listOf(
                            Between<String>(4..8)
                    )
            )
    }
    @Test fun StringOk() {
        assertEquals(StringTestData("abcd").valid().get("name")?.size, 0)
        assertEquals(StringTestData("1234").valid().get("name")?.size, 0)
        assertEquals(StringTestData("abcde").valid().get("name")?.size, 0)
        assertEquals(StringTestData("12345678").valid().get("name")?.size, 0)
    }
    @Test fun StringNg() {
        assertEquals(StringTestData("").valid().get("name")?.size, 1)
        assertEquals(StringTestData("123").valid().get("name")?.size, 1)
        assertEquals(StringTestData("123456789").valid().get("name")?.size, 1)
        assertEquals(StringTestData("12345678901234567890").valid().get("name")?.size, 1)
    }

    // List
    class ListTestData(val nums: List<Int>): Verifiable {
        override val rules: Map<String, List<Rule<*>>>
            get() = mapOf(
                    "nums" to listOf(
                            Between<List<Int>>(4..8)
                    )
            )
    }
    @Test fun ListOk() {
        assertEquals(ListTestData(listOf(1,2,3,4)).valid().get("nums")?.size, 0)
        assertEquals(ListTestData(listOf(1,2,3,4,5,6)).valid().get("nums")?.size, 0)
        assertEquals(ListTestData(listOf(1,2,3,4,5,6,7,8)).valid().get("nums")?.size, 0)
    }
    @Test fun ListNg() {
        assertEquals(ListTestData(listOf()).valid().get("nums")?.size, 1)
        assertEquals(ListTestData(listOf(1,2,3)).valid().get("nums")?.size, 1)
        assertEquals(ListTestData(listOf(1,2,3,4,5,6,7,8,9)).valid().get("nums")?.size, 1)
        assertEquals(ListTestData(listOf(1,2,3,4,5,6,7,8,9,0,1,2,3,4)).valid().get("nums")?.size, 1)
    }

}