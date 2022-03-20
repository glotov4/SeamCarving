//package seamcarving
//
//import java.awt.image.BufferedImage
//
//fun test(energyList: MutableList<MutableList<Double>>) {
//
//    val nodes = WIDTH * (HEIGHT + 2)
//    val edges: Array<DoubleArray> = Array(nodes) { DoubleArray(nodes) { -1.0 } }
//
//    val energyListZeroes = energyList
//    // для этого внутренний лист (отвечающий за столбец с пикселями) расширить на +1 +1
//    for (x in 0 until WIDTH){
//        energyListZeroes[x].add(0, 0.0)
//        energyListZeroes[x].add(0.0)
//    }
//
//    for (x in 0 until WIDTH)
//        for (y in 0 until HEIGHT)
//            edges[x][y] = energyList[x][y]
//
//    dijkstra(0, edges, nodes)
//}
//
//fun dijkstra(source: Int, edges: Array<DoubleArray>, nodes: Int) {
//    // Initialize single source
//    val d = DoubleArray(nodes) { Double.MAX_VALUE }
//    val pi = IntArray(nodes) { -1 }
//    d[source] = 0.0
//
//    val S: MutableList<Double> = ArrayList()
//    val Q: MutableList<Int> = (0 until nodes).toMutableList()
//
//    // Iterations
//    while (Q.isNotEmpty()) {
//        val u: Int = extractMin(Q, d)
//        S.add(u)
//
//        edges[u].forEachIndexed { v, vd ->
//            if (vd != -1.0 && d[v] > d[u] + vd) {
//                d[v] = d[u] + vd
//                pi[v] = u
//            }
//        }
//    }
//
//    println("d: ${d.contentToString()}")
//    println("pi: ${pi.contentToString()}")
//}
//
//fun extractMin(Q: MutableList<Int>, d: DoubleArray): Int {
//    var minNode = Q[0]
//    var minDistance: Double = d[0]
//
//    Q.forEach {
//        if (d[it] < minDistance) {
//            minNode = it
//            minDistance = d[it]
//        }
//    }
//
//    Q.remove(minNode)
//    return minNode
//}