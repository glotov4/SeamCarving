package seamcarving

import java.awt.image.BufferedImage

fun imageWithRemovedWSeams(image: BufferedImage, toRemove: Int) : BufferedImage {
    var activeImage = image

    repeat (toRemove) {
        val newImage = BufferedImage(activeImage.width - 1, activeImage.height, BufferedImage.TYPE_INT_RGB)
        val _energyList = findEnergy(activeImage)
        val seam = findVerticalSeam(activeImage, _energyList)

        for (row in 0 until newImage.height)
            for (x in 0 until newImage.width) {
                when {
                    x < seam[row] -> newImage.setRGB(x, row, activeImage.getRGB(x, row))
                    x > seam[row] -> newImage.setRGB(x - 1, row, activeImage.getRGB(x, row))
                }
            }
        activeImage = newImage
    }
    return activeImage
}