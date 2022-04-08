package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

/** Calculate intensity by normalizing energy **/
fun intensityRedraw(image: BufferedImage, energyList: MutableList<MutableList<Double>>, maxEnergy: Double) {

    for (x0 in 0 until image.width)
        for (y0 in 0 until image.height) {
            val intensity = (255 * energyList[x0][y0] / maxEnergy).toInt()
            val energyColor = Color(intensity, intensity, intensity)
            image.setRGB(x0, y0, energyColor.rgb)
        }
}