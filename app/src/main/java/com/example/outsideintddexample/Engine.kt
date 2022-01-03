package com.example.outsideintddexample

class Engine(
    var isTurnedOn: Boolean,
    var temperature: Int
) {
    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
}