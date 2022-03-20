package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage

fun removeSeam (inputImage: BufferedImage, toRemoveHorizontal: Int) : BufferedImage {
    var activeImage = inputImage
    repeat (toRemoveHorizontal) {
        val newImage = BufferedImage(activeImage.width - 1, activeImage.height, BufferedImage.TYPE_INT_RGB)
        val _energyList = findEnergy(activeImage)
        val seam = findVerticalSeam(activeImage, _energyList)

        for (y in seam.indices.reversed())
            newImage.setRGB(seam[y], y, activeImage.getRGB( seam[y] + 1, y) )
        activeImage = newImage
    }
    return activeImage
}