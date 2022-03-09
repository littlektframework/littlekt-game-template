package com.game.template

import com.lehaine.littlekt.Context
import com.lehaine.littlekt.ContextListener
import com.lehaine.littlekt.graphics.*
import com.lehaine.littlekt.graphics.gl.ClearBufferMask


class Game(context: Context) : ContextListener(context) {

    override suspend fun Context.start() {
        val batch = SpriteBatch(this)
        val camera = OrthographicCamera(graphics.width, graphics.height)

        onResize { width, height ->
            camera.update(width, height, context)
        }

        onRender {
            gl.clearColor(Color.DARK_GRAY)
            gl.clear(ClearBufferMask.COLOR_BUFFER_BIT)

            batch.use(camera.viewProjection) {
                Fonts.default.draw(it, "Hello LittleKt!", 0f, 0f)
            }
        }
    }
}