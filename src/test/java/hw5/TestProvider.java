package hw5;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestProvider {

    private static TestProvider instanse;

    @Getter
    @Setter
    private WebDriver driver;

    public static TestProvider getInstanse() {
        if (instanse == null) {
            instanse = new TestProvider();
        }
        return instanse;
    }
}
