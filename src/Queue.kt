package queue

import myList.*
import stack.Stack
import java.lang.Exception

internal object Queue {
    private var list: MyList = MyList()
    private val options: Array<String> = arrayOf(
        "1. Push element"
        , "2. Pop element"
        , "3. Read top"
        , "4. Is stack empty?"
        , "0. Exit"
    )

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun push(element: Int) {
        list.addFront(element)
    }

    fun pop(): Int {
        return list.removeFirst()!!.data
    }

    fun readTop(): Any {
        if(list.isEmpty()) return Exception()
        return list.findFirst()!!.data
    }

    fun displayMenu(index: Int) {

        while(true) {

            for(str in options) {
                print(str)
            }

            if (index === 0) return

            val queue = Queue

            when (index) {
                1 -> {
                    print("Write element")
                    val element = readLine()?.toInt() ?: 0
                    queue.push(element)
                }
                2 -> print(queue.pop())
                3 -> print(queue.readTop())
                4 -> print(queue.isEmpty())
                else -> true
            }
        }
    }
}