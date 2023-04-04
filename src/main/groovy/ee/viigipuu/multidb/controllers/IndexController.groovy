package ee.viigipuu.multidb.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    String index() {
        "Index controller"
    }
}
