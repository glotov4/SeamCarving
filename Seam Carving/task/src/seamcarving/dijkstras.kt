package seamcarving

import java.awt.image.BufferedImage

fun dijkstras(inputImage: BufferedImage, energyList: MutableList<MutableList<Double>>) {
    // 0 + energyList + 0 - в начало и конец каждой строчки добавляем нули
    val energyListZeroes = energyList
    // для этого внутренний лист (отвечающий за столбец с пикселями) расширить на +1 +1
    for (x in 0 until WIDTH){
        energyListZeroes[x].add(0, 0.0)
        energyListZeroes[x].add(0.0)
    }

    var source = 0
    var distance = 0

    for (x in 0 until WIDTH)
        for (y in 0 until HEIGHT + 2) {
            energyListZeroes
        }
}
/**
Set the current distance to the source to 00, for all other nodes assign it to \infty∞. Mark all nodes as unprocessed.
Find an unprocessed node uu with the smallest dist(u)dist(u).
For all unprocessed neighbors vv of the node uu, check whether the distance from uu to vv is less than the current distance to vv. If that is the case, that is dist(u) + weight(u, v) < dist(v)dist(u)+weight(u,v)<dist(v), update the current distance to vv to a smaller value.
When all the neighbors of uu are considered, mark uu as processed.
If there are no unprocessed nodes, the algorithm is finished. Otherwise, go back to the 2nd step.
After all the nodes are processed, each of the current distances dist(u)dist(u) is the shortest distance from the source to the node uu.
        **/