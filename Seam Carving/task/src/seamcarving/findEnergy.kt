package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import kotlin.math.sqrt

/** Calculate energy of every pixel & store it in the energyList **/
fun findEnergy(inputImage: BufferedImage) : MutableList<MutableList<Double>> {

    val width = inputImage.width
    val height = inputImage.height

    val energyList = MutableList(width) {MutableList(height) {0.0} }
    // calculate energy
    for (x0 in 0 until width)
        for (y0 in 0 until height) {
            // additional coordinates & "when" blocks are for accounting for border cases
            var x1 = x0
            val x2 = x0
            val y1 = y0
            var y2 = y0

            when (x0) {
                0 -> x1++
                width - 1 -> x1--
            }
            when (y0) {
                0 -> y2++
                height - 1 -> y2--
            }

            // calculate gradients X & Y
            val minusX = Color(inputImage.getRGB(x1 - 1, y1), false)
            val plusX = Color(inputImage.getRGB(x1 + 1, y1), false)
            val rX = minusX.red - plusX.red
            val gX = minusX.green - plusX.green
            val bX = minusX.blue - plusX.blue
            val gradientX = (rX * rX) + (gX * gX) + (bX * bX)

            val minusY = Color(inputImage.getRGB(x2, y2 - 1), false)
            val plusY = Color(inputImage.getRGB(x2, y2 + 1), false)
            val rY = minusY.red - plusY.red
            val gY = minusY.green - plusY.green
            val bY = minusY.blue - plusY.blue
            val gradientY = (rY * rY) + (gY * gY) + (bY * bY)

            // calculate energy of a pixel
            val energy = sqrt(gradientX.toDouble() + gradientY.toDouble())

            energyList[x0][y0] = energy
        }
    return energyList
}