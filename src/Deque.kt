package deque

import myList.*
import queue.Queue
import java.lang.Exception

internal object Deque {
    var list: MyList = MyList()

    private val options: Array<String> = arrayOf(
        "1. Push element in the head"
        , "2. Push element in the tail"
        , "3. Pop from head "
        , "4. Pop from tail"
        , "5. Read first element"
        , "6. Read last element"
        , "0. Is Empty?"
    )

    fun pushFirst(element: Int) {
        list.addFront(element)
    }

    fun popFirst(): Int {
        return list.removeFirst()!!.data
    }

    fun pushLast(element: Int) {
        list.addBack(element)
    }

    fun popLast(): Any {
        return list.removeLast()
    }

    fun readTop(): Int {
        return list.findFirst()!!.data
    }

    fun readLast(): Int {
        return list.findLast()!!.data
    }

    val isEmpty: Boolean
        get() = list.isEmpty()

    fun displayMenu(index: Int) {

        while(true) {

            for(str in options) {
                print(str)
            }

            if (index === 0) return

            val deque = Deque

            when (index) {
                1 -> {
                    print("Write element")
                    val element = readLine()?.toInt() ?: 0
                    deque.pushFirst(element)
                }
                2 -> {
                    print("Write element")
                    val element = readLine()?.toInt() ?: 0
                    deque.pushLast(element)
                }
                3 -> print(deque.popFirst())
                4 -> print(deque.popLast())
                5 -> print(deque.readTop())
                6 -> print(deque.readLast())
                else -> true
            }
        }
    }
}