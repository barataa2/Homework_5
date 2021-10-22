import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class main {
    @Test
    public void test(){
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized=true;
        Selenide.open("https://www.facebook.com/");
        $(byLinkText("Create New Account")).click();
        sleep(2000);
        $(byName("firstname")).setValue("giorgi");
        $(byName("lastname")).setValue("baratashvili");
        $(by("aria-label", "Mobile number or email")).setValue("123456789");
        $(byName("reg_passwd__")).setValue("Par0li1234");
        $(byName("birthday_month")).selectOption("Sep");
        $(byName("birthday_day")).selectOption(24);
        $(byName("birthday_year")).selectOption(23);
        $(byText("Custom")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.visible);
        $(by("aria-label", "Gender (optional)")).shouldBe(Condition.visible);
        $(byName("preferred_pronoun")).selectOption(2);
        $(byText("Female")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.hidden);
        $(by("aria-label", "Gender (optional)")).shouldBe(Condition.hidden);
        sleep(5000);

    }
}
