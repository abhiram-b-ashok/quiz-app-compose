package com.example.quizappcompose.ui.theme

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class CustomShape: Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        return Outline.Generic(Path().apply {
            moveTo(size.width * 0.01f, size.height * 0.5f)
            lineTo(size.width * 0.12f, size.height * 0.01f)
            lineTo(size.width * 0.88f, size.height * 0.01f)
            lineTo(size.width * 0.99f, size.height * 0.5f)
            lineTo(size.width * 0.88f, size.height * 0.99f)
            lineTo(size.width * 0.12f, size.height * 0.99f)
            lineTo(size.width * 0.01f, size.height * 0.5f)
        })
    }

}
