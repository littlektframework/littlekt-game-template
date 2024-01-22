package com.game.template

import com.lehaine.littlekt.Context
import com.lehaine.littlekt.ContextListener
import com.lehaine.littlekt.graph.node.resource.HAlign
import com.lehaine.littlekt.graphics.Color
import com.lehaine.littlekt.graphics.Fonts
import com.lehaine.littlekt.graphics.g2d.SpriteBatch
import com.lehaine.littlekt.graphics.g2d.shape.ShapeRenderer
import com.lehaine.littlekt.graphics.g2d.use
import com.lehaine.littlekt.graphics.gl.ClearBufferMask
import com.lehaine.littlekt.graphics.toFloatBits
import com.lehaine.littlekt.math.geom.degrees
import com.lehaine.littlekt.math.geom.radians
import com.lehaine.littlekt.util.viewport.ExtendViewport
import kotlin.time.Duration.Companion.milliseconds


class Game(context: Context) : ContextListener(context) {

    override suspend fun Context.start() {
        val batch = SpriteBatch(this)
        val shapeRenderer = ShapeRenderer(batch)
        val viewport = ExtendViewport(960, 540)
        val camera = viewport.camera
        var rotation = 0.radians
        var rotationTimer = 0.milliseconds

        onResize { width, height ->
            viewport.update(width, height, context)
        }

        onRender { dt ->
            gl.clearColor(Color.DARK_GRAY)
            gl.clear(ClearBufferMask.COLOR_BUFFER_BIT)

            batch.use(camera.viewProjection) {
                Fonts.default.draw(it, "Hello LittleKt!", 0f, 0f, align = HAlign.CENTER)
                shapeRenderer.filledRectangle(-50f, 50f, 100f, 50f, rotation, color = Color.RED.toFloatBits())
            }
            rotationTimer += dt
            if (rotationTimer > 10.milliseconds) {
                rotationTimer = 0.milliseconds
                rotation += 1.degrees
            }
        }
    }
}