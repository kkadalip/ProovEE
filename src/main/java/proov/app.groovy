package proov

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ThisWillActuallyRun {

    @RequestMapping("/wow")
    String home() {
        return "Hello World!"
    }

}