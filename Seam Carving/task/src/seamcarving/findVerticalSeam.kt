package seamcarving

import java.awt.image.BufferedImage

// sequence of indices for vertical seam
fun findVerticalSeam(image: BufferedImage, energyList: MutableList<MutableList<Double>>) : MutableList<Int> {

    val width = image.width
    val height = image.height

    val seam = MutableList(height) { 0 }

    val minEnergyToBot = MutableList(width) { MutableList(height) {0.0} }
    for (row in minEnergyToBot.indices)
        minEnergyToBot[row] = energyList[row]

    var minimum: Double
    for (row in height - 2 downTo 1) // start witn pre-last, stop at 0 bc it looks down
        for (x in 0 until width) {
            minimum = when (x) {
                0 -> minOf(
                    minEnergyToBot[x][row + 1],
                    minEnergyToBot[x + 1][row + 1])
                width - 1 -> minOf(
                    minEnergyToBot[x][row + 1],
                    minEnergyToBot[x - 1][row + 1])
                else -> minOf(
                    minEnergyToBot[x][row - 1],
                    minEnergyToBot[x + 1][row + 1],
                    minEnergyToBot[x - 1][row + 1]
                )
            }
            minEnergyToBot[x][row] = energyList[x][row] + minimum
        }

//    var minimum: Double
//    for (row in 1 until height)
//        for (x in 1 until width) { // find minimum energy pixel in the next row (lookup 2-3 pixels)
//            minimum = when (x) { //topMiddle(x,y-1) topLeft(x-1, y-1) topRight(x+1, y-1)
//                0 -> minOf(minEnergyToBot[x][row - 1], minEnergyToBot[x + 1][row - 1])
//                width - 1-> minOf(minEnergyToBot[x][row - 1], minEnergyToBot[x - 1][row - 1])
//                else -> minOf(minEnergyToBot[x - 1][row - 1], minEnergyToBot[x][row - 1], minEnergyToBot[x + 1][row - 1])
//            }
//            minEnergyToBot[x][row] = energyList[x][row] + minimum // add energy of that pixel to dpEnergy
//        }

    //indexOfMin = extension function to find index (column) of minimal value
    // we search for indexOfMin in the last row because...
    val indexOfMin = minEnergyToBot.indexOfMin(height - 1)
//    val yIndex = height - 1
    var xIndex = indexOfMin
    seam[height - 1] = indexOfMin

    for (yIndex in (height - 1) downTo 1) {
        when (xIndex) {
            0 -> {
                if (minOf(minEnergyToBot[xIndex][yIndex - 1], minEnergyToBot[xIndex + 1][yIndex - 1]) !=
                    minEnergyToBot[xIndex][yIndex - 1])
                    xIndex++
            }
            width - 1 -> {
                if (minOf(minEnergyToBot[xIndex][yIndex - 1], minEnergyToBot[xIndex - 1][yIndex - 1]) !=
                    minEnergyToBot[xIndex][yIndex - 1])
                    xIndex--
            }
            else -> {
                val minValue = minOf(minEnergyToBot[xIndex - 1][yIndex - 1], minEnergyToBot[xIndex][yIndex - 1],
                    minEnergyToBot[xIndex + 1][yIndex - 1])
                if (minValue == minEnergyToBot[xIndex - 1][yIndex - 1])
                    xIndex--
                else if (minValue != minEnergyToBot[xIndex][yIndex - 1])
                    xIndex++
            }
        }
        seam[yIndex] = xIndex
    }
    return seam
}

fun MutableList<MutableList<Double>>.indexOfMin(rowNumber: Int): Int {
    var minNum = this[0][rowNumber]
    var indexOfMin = 0
    for (x in 1 until this.size)
        if (this[x][rowNumber] < minNum) {
            indexOfMin = x
            minNum = this[x][rowNumber]
        }
    return indexOfMin
}