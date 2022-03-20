package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

fun seamMinEnergy (outputImage: BufferedImage, seamEnergyList: MutableList<Double>, seamList: MutableList<MutableList<Int>>) {

    var minEnergy =  seamEnergyList[0]
    var seamMinEnergyX =  0

    for (x in 0 until WIDTH)
        if (seamEnergyList[x] < minEnergy) {
            minEnergy = seamEnergyList[x]
            seamMinEnergyX = x
        }


    for (y in 0 until HEIGHT) {
        outputImage.setRGB(seamList[seamMinEnergyX][y], y, Color.RED.rgb)
    }

//    return seamList[seamMinEnergyX]
}
