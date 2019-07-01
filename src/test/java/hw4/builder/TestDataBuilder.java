package hw4.builder;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TestDataBuilder {

    // TODO Java code convention for the class fields name
    private String Odd;
    private String Even;
    private List<String> Elements;
    private String Colors;
    private String Metals;
    private List<String> Vegetables;

    // TODO Is this getter required here?
    public String getOdd() {
        return Odd;
    }
}
