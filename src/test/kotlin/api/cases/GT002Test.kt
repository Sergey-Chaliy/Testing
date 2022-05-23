package api.cases

import api.check.CheckClass
import core.SwagerPropirties
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.testng.annotations.Test

class GT002Test {

    //в тесте намеренно сделана ошибка в имени продукта TestProductY
    @Test
    fun gt_T002_test () {
        var logger: Logger = LogManager.getLogger()
        val checkClass = CheckClass()
        val requestId = "a92e0ca6-5d53-4baf-ab26-486c3c7b0446"

        /**
         * Шаг 1. Отправка запроса
         * Шаг 2. Проверка статуса сообщения
         */
        logger.info("\n=== Шаг 1,2 ===\n")
        var getUrl = "${SwagerPropirties.baseUrl}${SwagerPropirties.endPointGetRequest}$requestId"
        println(getUrl)

        var extractJson = SendRequestHelper.sendGetRequestId(getUrl)
        logger.info("Шаг 1,2 успешно пройден Запрос отправлен, статус код 200")

        /**
         * Шаг 3. Проверка имени продукта
         */
        logger.info("\n=== Шаг 3 ===\n")
        var productName = extractJson.getString("value.productName")

        checkClass.checkValueEqual(productName, "TestProducty")
        logger.info("Шаг 3  успешно пройден")
    }
}