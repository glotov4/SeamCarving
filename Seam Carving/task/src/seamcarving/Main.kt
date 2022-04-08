package seamcarving

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

var WIDTH = -1
var HEIGHT = -1

// -in sky.png -out sky_seam.png
fun main( args:Array<String> ) {

    /** Read arguments, process inputImage, copy it to outputImage **/
    val inputFileName = args[1]
    val outputFileName = args[3]
    val toRemoveWidth = args[5].toInt()
    val toRemoveHeight = args[7].toInt()

    val inputImageFile = File(inputFileName)
    val outputImageFile = File(outputFileName)

    val inputImage: BufferedImage = ImageIO.read(inputImageFile)
    var outputImage: BufferedImage = inputImage

    WIDTH = inputImage.width
    HEIGHT = inputImage.height

    /** Calculate energy of every pixel & store it in the energyList **/
    val energyList = findEnergy(inputImage)

    /** findVerticalSeam **/
//    val verticalSeam = findVerticalSeam(inputImage, energyList)

    /** toRemoveVertical **/
    outputImage = imageWithRemovedWSeams(inputImage, toRemoveWidth)
    outputImage = outputImage.getTransposed()
    outputImage = imageWithRemovedWSeams(outputImage, toRemoveHeight)
    outputImage = outputImage.getTransposed()

//    val imageTest = imageWithRemovedWSeams(inputImage, toRemoveWidth)
//    val energyListTest = findEnergy(imageTest)



    /** colorSeam **/
//    fun colorSeam(seam: MutableList<Int>) {
//        for (y in seam.indices) {
//            outputImage.setRGB(seam[y], y,  Color.RED.rgb)
//        }
//    }
//    colorSeam(verticalSeam)

    /** Store all the seams of the image List[x][y](lowEnergyX)  **/
//    val seamList = seam(energyList)
//    val dijkstrasCall = dijkstras(inputImage, energyList)

    /** Calculate energy of every seam  **/
//    val seamEnergyList = seamEnergy(energyList, seamList )

    /** Find and color the seam with the lowest energy  **/
//    val seamMinEnergy1 = seamMinEnergy(outputImage, seamEnergyList, seamList)

    /** DEPRECATED - Calculate maxEnergy of pixels in the image **/
//    val maxEnergy = findMaxEnergy(energyList)
//    val maxEnergyTest = findMaxEnergy(energyListTest)

    /** DEPRECATED - Calculate intensity by normalizing energy & change color of pixels accordingly **/
//    intensityRedraw(outputImage, energyList, maxEnergy)
//    intensityRedraw(imageTest, energyListTest, maxEnergyTest)
//    outputImage = imageTest

    fun saveImage(image: BufferedImage, imageFile: File) {
        ImageIO.write(image, "png", imageFile)
    }
    saveImage(outputImage, outputImageFile)
}