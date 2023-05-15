package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("1,2를 ,로 split했을때 1과 2로 잘 분리되는지 확인")
    @Test
    void one() {

        String test = "1,2";
        String[] con = test.split(",");
        assertThat(con[0]).contains("1");

        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지?.
        test = "1";
        con = test.split(",");
        assertThat(con).containsExactly("1"); // 정확히 이것을 포함하는지


    }

    @Test
    public void two() {
//        "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록

        String value = "(1,2)";
//        String result= value.substring(1).substring(0,3);
        String result = value.substring(1, (value.length() - 1)); // beginIndex 포함 endIndex 포함하지 않음

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void three() {
        String value = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(3);
                })
                .withMessage("String index out of range: %s", "3")
                .withMessageContaining("String index out of range:");

        assertThatCode(() -> {
            "abc".charAt(3);
        }).doesNotThrowAnyException();

    }

//@Test
//    public void testException() {
//        assertThatExceptionOfType(IOException.class).isThrownBy(() -> { throw new IOException("boom!"); })
//                .withMessage("%s!", "boom")
//                .withMessageContaining("boom")
//                .withNoCause();
//    }
}
