package com.game.template

import com.littlekt.createLittleKtApp

fun main() {
    createLittleKtApp {
        width = 960
        height = 540
        title = "LittleKt Game Template"
        canvasId = "canvas"
    }.start {
        Game(it)
    }
}