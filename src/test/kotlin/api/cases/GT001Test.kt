package api.cases

import api.check.CheckClass
import core.SwagerPropirties
import org.testng.annotations.Test
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager


class GT001Test {

    @Test
    fun gt_T001_test (){
        var logger: Logger = LogManager.getLogger()
        val checkClass = CheckClass()
        val requestId = "a92e0ca6-5d53-4baf-ab26-486c3c7b0446"

        //Возможен вариант разделения данного теста на подтесты
        // Шаг 1 выводим в отдельную функцию с анотацией @AfterTest или @AfterSute
        // но на мой взгляд правильней 1 раз получить Json объект и с ним работать

        /**
         * Шаг 1. Отправка запроса
         * Шаг 2. Проверка статуса сообщения
         */
        logger.info("\n=== Шаг 1,2 ===\n")
        var getUrl = "${SwagerPropirties.baseUrl}${SwagerPropirties.endPointGetRequest}$requestId"
        println(getUrl)

        var extractJson =SendRequestHelper.sendGetRequestId(getUrl)
        logger.info("Запрос отправлен, статус код 200")

        /**
         * Шаг 3. Проверка имени продукта
         */
        logger.info("\n=== Шаг 3 ===\n")
        var productName = extractJson.getString("value.productName")

        checkClass.checkValueEqual(productName, "TestProduct")
        logger.info("Имя соответствует TestProduct")

        /**
         * Шаг 4. Проверка Id категории
         */
        logger.info("\n=== Шаг 4 ===\n")
        var categoriesId = extractJson.getString("value.categories.id")

        checkClass.checkValueEqual(categoriesId, "[ddf35cb6-f6b1-451b-ab7a-6ebe73b3def1]")
        logger.info("Id соответствует ddf35cb6-f6b1-451b-ab7a-6ebe73b3def1")

        /**
         * Шаг 5. Проверка Name категории
         */
        logger.info("\n=== Шаг 5 ===\n")
        var categoriesName = extractJson.getString("value.categories.name")

        checkClass.checkValueEqual(categoriesName, "[TestCategory]")
        logger.info("Name соответствует TestCategory")

        /**
         * Шаг 6. Проверка Brand категории
         */
        logger.info("\n=== Шаг 6 ===\n")
        var categoriesBrand = extractJson.getString("value.categories.brand")

        checkClass.checkValueEqual(categoriesBrand, "[Test]")
        logger.info("Brand соответствует Test")

        /**
         * Шаг 7. Проверка isVisible категории
         */
        logger.info("\n=== Шаг 7 ===\n")
        var categoriesVisible = extractJson.getString("value.categories.isVisible")

        checkClass.checkValueEqual(categoriesVisible, "[true]")
        logger.info("isVisible соответствует true")

        /**
         * Шаг 8. Проверка Created категории
         */
        logger.info("\n=== Шаг 8 ===\n")
        var categoriesCreated = extractJson.getString("value.categories.created")

        checkClass.checkValueEqual(categoriesCreated, "[2022-05-18 04:54:12]")
        logger.info("Created соответствует 2022-05-18 04:54:12")

        /**
         * Шаг 9. Проверка Modified категории
         */
        logger.info("\n=== Шаг 8 ===\n")
        var categoriesModified = extractJson.getString("value.categories.modified")

        checkClass.checkValueEqual(categoriesModified, "[2022-05-18 04:54:12]")

        // так же возможен вариант при работе с базой данных для полей которые хранятся там
        // нативным запросом (при помощи JDBS или Hibernate) получаем данные, а потом их сравниваем
        // CrudJdbc().- класс описывающий работу с БД SelectNativJdbc - метод работы с нативными запросами (это для примера)
        // val categoriesModifiedDB = CrudJdbc().SelectNativJdbc(
        // "SELECT modified" +
        //   "FROM TestProduct" +
        //     "WHERE business_id='a92e0ca6-5d53-4baf-ab26-486c3c7b0446'"

        // соответственно проверка выглядела бы так
        // checkClass.checkValueEqual(categoriesModified, "$categoriesModifiedDB")
        logger.info("Modified соответствует 2022-05-18 04:54:12")

        /**
         * Шаг 10. Проверка amount в value
         */
        logger.info("\n=== Шаг 10 ===\n")
        var valueAmount = extractJson.getString("value.amount")

        checkClass.checkValueEqual(valueAmount, "10.0")
        logger.info("amount соответствует 10.0")

        /**
         * Шаг 11. Проверка discount в value
         */
        logger.info("\n=== Шаг 11 ===\n")
        var valueDiscount = extractJson.getString("value.discount")

        checkClass.checkValueEqual(valueDiscount, "5.0")
        logger.info("Discount соответствует 5.0")

        /**
         * Шаг 12. Проверка percentDiscount в value
         */
        logger.info("\n=== Шаг 12 ===\n")
        var valuePercentDiscount = extractJson.getString("value.percentDiscount")

        checkClass.checkValueEqual(valuePercentDiscount, "10.0")
        logger.info("percentDiscount соответствует 10.0")

        /**
         * Шаг 13 Проверка isVisible в value
         */
        logger.info("\n=== Шаг 13 ===\n")
        var valueVisible = extractJson.getString("value.isVisible")

        checkClass.checkValueEqual(valueVisible, "true")
        logger.info("isVisible соответствует true")

        /**
         * Шаг 14. Проверка Created в value
         */
        logger.info("\n=== Шаг 14 ===\n")
        var valueCreated = extractJson.getString("value.created")

        checkClass.checkValueEqual(valueCreated, "2022-05-18 04:54:12")
        logger.info("Created соответствует 2022-05-18 04:54:12")

        /**
         * Шаг 15. Проверка Modified в value
         */
        logger.info("\n=== Шаг 15 ===\n")
        var valueModified = extractJson.getString("value.modified")

        checkClass.checkValueEqual(valueModified, "2022-05-18 04:54:12")
        logger.info("Modified соответствует 2022-05-18 04:54:12")


        /**
         * Шаг 15. Проверка длины списка (в нашем случае строки)
         */
        logger.info("\n=== Шаг 16 ===\n")
        var categoriesLength = extractJson.getString("value.categories")

        checkClass.lenghMas(categoriesLength, 149)
        logger.info("длина строки соответствует ожидаемой")
    }
}