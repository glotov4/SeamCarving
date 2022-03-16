package seamcarving

import java.awt.image.BufferedImage

fun seam(inputImage: BufferedImage, energyList: MutableList<MutableList<Double>>) {

    /** Find pixel with the lowest energy to start with  **/
    /** lookup pixels in front of starting pixel (account for border cases) **/
    /** go to the pixel with the lowest energy **/
    /** stop **/

    val width = inputImage.width
    val height = inputImage.height

    for (x in 0 until width)
        for (y in 0 until height) {

        }
}