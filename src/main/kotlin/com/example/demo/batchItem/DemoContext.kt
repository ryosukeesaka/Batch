package com.example.demo.batchItem

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix="demo")
class DemoContext(var writeSize: Int) {
}