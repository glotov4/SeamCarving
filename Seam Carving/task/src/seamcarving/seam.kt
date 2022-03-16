package seamcarving

import org.w3c.dom.css.RGBColor
import java.awt.Color
import java.awt.image.BufferedImage

fun seam(outputImage: BufferedImage, energyList: MutableList<MutableList<Double>>) {

    val width = outputImage.width
    val height = outputImage.height

    var  minEnergyX1 = 0
    for (x in 0 until width)
        if (energyList[x][0] < minEnergyX1) minEnergyX1 = x

    val red = Color(255,0, 0)
    outputImage.setRGB(minEnergyX1, 0, red.rgb)

    var activeX = minEnergyX1
    // startX -> lookup in front -> find low energy -> set color to red -> repeat
    for (y in 0 until height - 1) {
        var firstX: Int
        var lastX: Int
        when (activeX) {
            0 -> {
                firstX = activeX
                lastX = activeX + 1
            }
            width -> {
                firstX = activeX - 1
                lastX = activeX
            }
            else -> {
                firstX = activeX - 1
                lastX = activeX + 1
            }
            }

        var xOfMin = activeX
        for (xNext in firstX .. lastX) {
            if (energyList[xNext][y + 1] < energyList[xOfMin][y + 1]) xOfMin = xNext
        }

        activeX = xOfMin
        outputImage.setRGB(activeX, y + 1, red.rgb)
    }
}