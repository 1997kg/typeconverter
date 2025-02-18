package hello.typeconverter.controller;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormatterController {


    //"10.000" ->10000
    //"2025-01-15 13:23:36 -> localDatetime
    @GetMapping("/formatter/edit")
    public String formatterForma(Model model){
        Form form = new Form();
        form.setNumber(1000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";

    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form){
        return "formater-view";
    }


    @Data
    static class  Form{
        @NumberFormat(pattern = "###,##")
        private Integer number;

        @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }
}
