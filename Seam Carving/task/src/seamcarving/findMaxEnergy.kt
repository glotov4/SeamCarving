package seamcarving

/** Calculate maxEnergy of pixels in the image **/
fun findMaxEnergy(energyList: MutableList<MutableList<Double>>) : Double {
    var maxEnergy = 0.0
    energyList.forEach { outsideList -> outsideList.forEach {
            elementInList -> if (elementInList > maxEnergy) maxEnergy = elementInList}
    }
    return maxEnergy
}