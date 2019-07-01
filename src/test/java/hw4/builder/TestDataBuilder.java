package hw4.builder;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TestDataBuilder {

    private String Odd;
    private String Even;
    private List<String> Elements;
    private String Colors;
    private String Metals;
    private List<String> Vegetables;

    public String getOdd() {
        return Odd;
    }
}
