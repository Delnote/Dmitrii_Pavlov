package hw4.builder;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TestDataBuilder {

    private String odd;
    private String even;
    private List<String> elements;
    private String colors;
    private String metals;
    private List<String> vegetables;
}
