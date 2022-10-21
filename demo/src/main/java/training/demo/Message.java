package training.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Message {

    private String text;

    public Message(@JsonProperty("text") String text) {
        this.text = text;
    }
}
