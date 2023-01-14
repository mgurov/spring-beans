package com.example.demo.pkg

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

class ComponentCBeaned {
    fun describeMe() = "ComponentCBeaned"
}

val beans = beans {
    bean<ComponentCBeaned>()
}

// see application.properties
class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) = beans.initialize(context)
}
