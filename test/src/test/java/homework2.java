import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class homework2 {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Denis");
        $("#lastName").setValue("Grigoriev");
        $("#userEmail").setValue("dennn@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $(("#dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1977");
        $((".react-datepicker__day--010")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/crazy.jpg"));
        $("#currentAddress").scrollTo().setValue("Moscow, Red Square");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();
//  Проверка формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Denis Grigoriev"),
                (text("dennn@gmail.com")),
                (text("1234567890")),
                (text("Male")),
                (text("10 September,1977")),
                (text("Maths, Chemistry")),
                (text("Reading")),
                (text("crazy.jpg")),
                (text("Moscow, Red Square")),
                (text("NCR Delhi")));
    }
}
