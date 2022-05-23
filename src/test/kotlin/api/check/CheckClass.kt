package api.check

import org.apache.logging.log4j.message.MessageFactory2
import kotlin.coroutines.CoroutineContext
import kotlin.test.assertEquals

class CheckClass {

    /**
     * Метод для проверки соответствия значений
     * @param expected - проверяемое значение (полученное)
     * @param actual - эталонное значение
     */
    fun checkValueEqual(expected: String, actual:String){
        assertEquals("$expected",
            "$actual",
            "Полученное значение ($expected) не соответствует ожидаемому ($actual)")
    }

    /**
     * Метод с точки зрения тестирования не несет проверок, а просто показывает еще одну проверку
     * проверяет его длину
     * @param expected список который необходимо преобразовать в строку и посчитать его длину
     * @param actual ожидаемое число
     */
    fun lenghMas (expected: String, actual:Int){
      var expectedLengh = expected.length
        assertEquals("$expectedLengh",
            "$actual",
            "Полученное значение ($expectedLengh) не соответствует ожидаемому ($actual)")
    }
}