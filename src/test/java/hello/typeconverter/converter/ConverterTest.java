package hello.typeconverter.converter;

import hello.typeconverter.controller.converter.IntegerToStringConverter;
import hello.typeconverter.controller.converter.IpPortToStringConverter;
import hello.typeconverter.controller.converter.StringToIntegerConverter;
import hello.typeconverter.controller.converter.StringToIpConverter;
import hello.typeconverter.controller.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.PSource;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {
    
    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);

    }

    @Test
    void integerToStringConverter(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void StringToIpPort(){
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
    @Test
    void ipPortToStringConverter() {
        StringToIpConverter converter = new StringToIpConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
