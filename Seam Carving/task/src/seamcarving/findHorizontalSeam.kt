package seamcarving

import java.awt.image.BufferedImage

fun findHorizontalSeam(image: BufferedImage) : MutableList<Int> {

    val transposedImage = image.getTransposed()
    val energyListTransposed = findEnergy(transposedImage)
    val seam = findVerticalSeam(transposedImage, energyListTransposed)
    return seam
}

fun BufferedImage.getTransposed(): BufferedImage {
    val transposedImage = BufferedImage(this.height, this.width, BufferedImage.TYPE_INT_RGB)
    repeat(transposedImage.width) { w ->
        repeat(transposedImage.height) { h ->
            transposedImage.setRGB(w, h, this.getRGB(h, w))
        }
    }
    return transposedImage
}