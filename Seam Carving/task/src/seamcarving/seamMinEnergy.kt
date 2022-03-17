package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

fun seamMinEnergy (outputImage: BufferedImage, seamEnergyList: MutableList<Double>, seamList: MutableList<MutableList<Int>>) {
    val width = outputImage.width
    val height = outputImage.height
    var minEnergy =  seamEnergyList[0]
    var seamMinEnergyX =  0

    for (x in 0 until width)
        if (seamEnergyList[x] < minEnergy) {
            minEnergy = seamEnergyList[x]
            seamMinEnergyX = x
        }
    println(minEnergy)

    val red = Color(255,0, 0)
    for (y in 0 until height) {
        outputImage.setRGB(seamList[seamMinEnergyX][y], y, red.rgb)
    }

//    return seamList[seamMinEnergyX]
}
