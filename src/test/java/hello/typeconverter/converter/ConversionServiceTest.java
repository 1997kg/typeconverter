package hello.typeconverter.converter;

import hello.typeconverter.controller.converter.IntegerToStringConverter;
import hello.typeconverter.controller.converter.IpPortToStringConverter;
import hello.typeconverter.controller.converter.StringToIntegerConverter;
import hello.typeconverter.controller.converter.StringToIpConverter;
import hello.typeconverter.controller.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        //등록
        DefaultConversionService conversionService =  new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //사용
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10); //문자 -> 숫자
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10"); //숫자 -> 문자

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
