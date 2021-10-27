package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://yandex.ru/'", () ->
                open("https://yandex.ru/"));

        step("Page title should have text 'Яндекс'", () -> {
            String expectedTitle = "Яндекс";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://yandex.ru/'", () ->
                open("https://yandex.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @CsvSource(value = {
            "market; Яндекс.Маркет — покупки с быстрой доставкой",
            "video; видео: 4 тыс. видео найдено в Яндекс.Видео",
            "images; Яндекс.Картинки: поиск изображений в интернете, поиск по изображению",
            "news; Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн",
            "maps; Яндекс.Карты — транспорт, навигация, поиск мест",
            "translate; Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.",
            "music; Яндекс.Музыка — собираем музыку и подкасты для вас",
            "tv; Программа передач ТВ — Яндекс.Телепрограмма",
            "autoru; Авто.ру: купить, продать и обменять машину в Санкт-Петербурге"
    }, delimiter = ';')

    @ParameterizedTest
    @DisplayName("Open all tabs")
    void openTabs(String tabName, String expectedTitle) {
        step("Open url 'https://yandex.ru/'", () ->
                open("https://yandex.ru/"));

        step("Click on tab", () ->
                $("[data-id='" + tabName + "']").click());

        step("Switch to opened window", () ->
                switchTo().window(1));

        step("Check if opened tab has correct title", () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}