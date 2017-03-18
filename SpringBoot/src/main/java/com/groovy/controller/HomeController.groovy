package com.groovy.controller

import com.groovy.Demo.Orgernazation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class HomeController {

    @Value('${json.indent.output:true}')
    String jsonIndentOutput

    @Value('${test:false}')
    String test

    @GetMapping("/home")
    def home(){
        log.info("get org ... ")
        def org = new Orgernazation(name: 'org',description: 'just a description')

//        def mjv = new MappingJacksonValue(org)
//        mjv.filters = new SimpleFilterProvider()
//                .addFilter(AnnotationUtils.findAnnotation(User,JsonFilter).value(),serializeAllExcept('password','age'))
//        log.info("======================= mjv ========================")
//        log.info(mjv)
//        def user = new User(username: 'shen',password: '123123',birth: LocalDate.now())
//        log.info(jsonIndentOutput)
//        log.info(test)
//        user
//
//        def node = JsonNodeFactory.instance.objectNode()
//        node.put('code':'-1')
//        node.put('msg':'error')
//        node as String

//        'test return code'
        org
    }
}
