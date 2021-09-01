package code;

import lombok.Data;

@Data
public class OurSchool {
    private String name;
    public OurSchool(String name) {
        this.name = name;
    }
}
