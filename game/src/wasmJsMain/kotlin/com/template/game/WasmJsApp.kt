package com.template.game

import com.game.template.Game
import com.lehaine.littlekt.createLittleKtApp
import com.lehaine.littlekt.graphics.Color

fun main() {
    createLittleKtApp {
        title = "LittleKt Game Template"
        backgroundColor = Color.DARK_GRAY
        canvasId = "canvas"
    }.start {
        Game(it)
    }
}