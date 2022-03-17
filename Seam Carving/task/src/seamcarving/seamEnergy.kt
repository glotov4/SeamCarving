package seamcarving

import java.awt.image.BufferedImage

fun seamEnergy(inputImage: BufferedImage, energyList: MutableList<MutableList<Double>>, seamList: MutableList<MutableList<Int>>, ) : MutableList<Double> {

    val width = inputImage.width
    val height = inputImage.height

    val seamEnergyList = MutableList(width) { 0.0 }

    for (x in 0 until width)
        for (y in 0 until height) {
            seamEnergyList[x] += energyList[seamList[x][y]][y]
        }

    return seamEnergyList
}