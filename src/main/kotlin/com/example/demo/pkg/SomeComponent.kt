package com.example.demo.pkg

import org.springframework.stereotype.Component

@Component
class SomeComponent(
    private val componentB: ComponentB
) {
    fun describeMe() = "SomeComponent -> ${componentB.describeMe()}"
}