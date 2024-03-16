package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("Hello") //hello라는 url로 오면 이 hello 함수가 호출됨
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!"); //값을 담음
        return "hello"; //return은 화면 이름 - 관례상 resources의 templates에 있는 화면
    }
}
