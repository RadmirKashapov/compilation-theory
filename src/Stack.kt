package stack

import myList.*
import java.lang.Exception

/**
 * Реализация стэка с использованием однонапрвленного списка
 */
internal object Stack {
    var list: MyList = MyList()
    private var top: Int = -1

    private val options: Array<String> = arrayOf(
        "1. Push element"
        , "2. Pop element"
        , "3. Read top"
        , "4. Is stack empty?"
        , "0. Exit"
    )

    /**
     * Добавляет [element] в конец стэка
     */
    fun push(element: Int) {
        list.addBack(element)
        top++
    }

    /**
     * Возвращает элемент из стэка
     * Если стек пуст, вызывается исключение
     */
    fun pop(): Any {
        return if(top == -1) Exception("Stack is Empty")
        else {
            top--
            list.removeLast()
        }
    }

    /**
     * @return значение последнего в списке элемента
     */
    fun readTop(): Int {
        return list.findLast()!!.data
    }

    /**
     * @return true, если список пуст
     */
    val isEmpty: Boolean
        get() = top == -1

    /**
     * Вызов консольного меню
     */
    fun displayMenu(index: Int) {

        while(true) {

            for(str in options) {
                print(str)
            }

            if (index === 0) return

            val stack = Stack

            when (index) {
                1 -> {
                        print("Write element")
                        val element = readLine()?.toInt() ?: 0
                        stack.push(element)
                    }
                2 -> print(stack.pop())
                3 -> print(stack.readTop())
                4 -> print(stack.isEmpty)
                else -> true
                }
            }
    }
}