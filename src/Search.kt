package search

/**
 * Бинарный поиск элемента [key] в массиве [array]
 */
fun binarySearch(array: Array<Int>, key: Int): Int {
    var left = 0
    var right = array.size
    var index: Int
    while(true) {
        if(left > right) return -1
        index = left + (right + left) / 2
        if(array[index] < key) left = index + 1
        if(array[index] > key)  right = index - 1
        if(array[index] == key) return index
    }
}

/**
 * Линейный поиск элемента [key] в массиве [array].
 * @return инедекс элемента. Если его нет, вохвращается -1.
 */
fun linearSearch(array: Array<Int>, key: Int): Int {
    for (i in array.indices) {
        if (array[i] === key) return i
    }
    return -1
}