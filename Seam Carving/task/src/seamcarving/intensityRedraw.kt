package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

/** Calculate intensity by normalizing energy **/
fun intensityRedraw(inputImage: BufferedImage, energyList: MutableList<MutableList<Double>>, maxEnergy: Double, outputImage: BufferedImage) {

    val width = inputImage.width
    val height = inputImage.height

    for (x0 in 0 until width)
        for (y0 in 0 until height) {
            val intensity = (255 * energyList[x0][y0] / maxEnergy).toInt()
            val energyColor = Color(intensity, intensity, intensity)
            outputImage.setRGB(x0, y0, energyColor.rgb)
        }
}