package seamcarving

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

// -in sky.png -out sky_seam.png
fun main( args:Array<String> ) {

    /** Read arguments, process inputImage, copy it to outputImage **/
    val inputFileName = args[1]
    val outputFileName = args[3]

    val inputImageFile = File(inputFileName)
    val outputImageFile = File(outputFileName)

    val inputImage: BufferedImage = ImageIO.read(inputImageFile)
    val outputImage: BufferedImage = inputImage

    /** Calculate energy of every pixel & store it in the energyList **/
    val energyList = findEnergy(inputImage)

    /** Find pixel with the lowest energy to start with  **/
    /** lookup pixels in front of starting pixel (account for border cases) **/
    /** go to the pixel with the lowest energy **/
    /** stop **/



    /** Calculate maxEnergy of pixels in the image **/
    val maxEnergy = findMaxEnergy(energyList)

    /** Calculate intensity by normalizing energy & change color of pixels accordingly **/
    intensityRedraw(inputImage, energyList, maxEnergy, outputImage)

    fun saveImage(image: BufferedImage, imageFile: File) {
        ImageIO.write(image, "png", imageFile)
    }
    saveImage(outputImage, outputImageFile)
}