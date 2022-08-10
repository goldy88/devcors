package application1.lesson5.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("messages")
public class TextConfiguration {

    private String stringText1;
    private String stringText2;


    public String getStringText1() {
        return stringText1;
    }

    public void setStringText1(String stringText1) {
        this.stringText1 = stringText1;
    }

    public String getStringText2() {
        return stringText2;
    }

    public void setStringText2(String stringText2) {
        this.stringText2 = stringText2;
    }
}
