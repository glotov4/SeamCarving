package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

fun seam(inputImage: BufferedImage, energyList: MutableList<MutableList<Double>>) : MutableList<MutableList<Int>> {
    // TODO: make width + height global variables

    val width = inputImage.width
    val height = inputImage.height

    // 2D array
    val seamList = MutableList(width) { MutableList(height) { 0 } }

    // startX -> lookup 3 pixels in front -> find pixel with the lowest energy -> save pixel's cords & energy -> repeat
    for (x in 0 until width) {
        seamList[x][0] = x
        var activeX = x
        for (y in 0 until height - 1) {

            // firstX & lastX - boundaries for lookup function. depend on border cases
            var leftBoundaryX: Int
            var rightBoundaryX: Int
            // account for border cases
            when (activeX) {
                0 -> {
                    leftBoundaryX = activeX
                    rightBoundaryX = activeX + 1
                }
                width - 1 -> {
                    leftBoundaryX = activeX - 1
                    rightBoundaryX = activeX
                }
                else -> {
                    leftBoundaryX = activeX - 1
                    rightBoundaryX = activeX + 1
                }
            }

            // looking at the energy of 2-3 pixels (2 if border case) in the next line (y+1).
            var lowEnergyX = activeX // lowEnergyX - X of pixel with the lowest energy
            for (nextLineX in leftBoundaryX .. rightBoundaryX) {
                if (energyList[nextLineX][y + 1] < energyList[lowEnergyX][y + 1]) lowEnergyX = nextLineX
            }
            seamList[x][y + 1] = lowEnergyX // write down cords of lowEnergyX

            // proceed to the X with the lowest energy
            activeX = lowEnergyX
        }
    }
    return seamList
}