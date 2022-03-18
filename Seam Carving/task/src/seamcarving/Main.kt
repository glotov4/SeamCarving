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

    /** Store all the seams of the image List[x][y](lowEnergyX)  **/
    val seamList = seam(inputImage, energyList)

    /** Calculate energy of every seam  **/
    val seamEnergyList = seamEnergy(inputImage, energyList, seamList )

    /** Find and color the seam with the lowest energy  **/
    val seamMinEnergy = seamMinEnergy(outputImage, seamEnergyList, seamList)
    print(seamMinEnergy)

    /** DEPRECATED - Calculate maxEnergy of pixels in the image **/
//    val maxEnergy = findMaxEnergy(energyList)

    /** DEPRECATED - Calculate intensity by normalizing energy & change color of pixels accordingly **/
//    intensityRedraw(outputImage, energyList, maxEnergy)

    fun saveImage(image: BufferedImage, imageFile: File) {
        ImageIO.write(image, "png", imageFile)
    }
    saveImage(outputImage, outputImageFile)
}