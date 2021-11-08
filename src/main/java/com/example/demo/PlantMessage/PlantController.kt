package com.example.demo.PlantMessage

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plants")
class PlantController {

    @GetMapping
    fun getPlant(): String {
        return "Ficus"
    }

}