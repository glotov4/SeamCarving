package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

/** Calculate intensity by normalizing energy **/
fun intensityRedraw(outputImage: BufferedImage, energyList: MutableList<MutableList<Double>>, maxEnergy: Double) {

    for (x0 in 0 until WIDTH)
        for (y0 in 0 until HEIGHT) {
            val intensity = (255 * energyList[x0][y0] / maxEnergy).toInt()
            val energyColor = Color(intensity, intensity, intensity)
            outputImage.setRGB(x0, y0, energyColor.rgb)
        }
}