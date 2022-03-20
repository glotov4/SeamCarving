package seamcarving

import java.awt.image.BufferedImage

fun seamEnergy(energyList: MutableList<MutableList<Double>>, seamList: MutableList<MutableList<Int>>, )
                : MutableList<Double> {

    val seamEnergyList = MutableList(WIDTH) { 0.0 }

    for (seam in 0 until WIDTH)
        for (y in 0 until HEIGHT) {
            seamEnergyList[seam] += energyList[seamList[seam][y]][y]
        }
//    for (x in 0 until 200)
//        println(seamList[x])
    return seamEnergyList
}