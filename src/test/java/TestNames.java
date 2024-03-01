import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestNames {

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "abdbd", "aaaa", "ssee"})
    public void CheckName(String str){
        Names name = new Names(str);

    }
}
