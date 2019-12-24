package myList

internal class MyList{

    internal class ListElement {
        var next: ListElement? = null
        var data: Int = 0
    }

    private var head: ListElement? = null
    private var tail: ListElement? = null


    fun isEmpty(): Boolean {
        if(head === tail && head === null) return true
        return false
    }

    fun addFront(data: Int) {
        val element = ListElement()
        element.data = data

        if(head === null) {
            head = element
            tail = element
        }
        else {
            element.next = head
            head = element
        }
    }

    fun addBack(data: Int) {
        val element = ListElement()
        element.data = data

        if(tail === null) {
            head = element
            tail = element
        }
        else {
            tail?.next = element
            tail = element
        }
    }

    fun findLast(): ListElement? {
        return tail
    }

    fun findFirst(): ListElement? {
        return head
    }

    fun removeFirst(): ListElement? {
        val elem: ListElement? = head
        head = head?.next
        return elem
    }

    fun printList() //печать списка
    {
        var t = head //получаем ссылку на первый элемент
        while (t != null) //пока элемент существуе
        {
            print(t.data.toString() + " ") //печатаем его данные
            t = t.next //и переключаемся на следующий
        }
    }

    fun removeLast(): Any {
        if(head === null && tail === null) return Exception("List is empty")

        var t = head
        while (t?.next != null) { //пока следующий элемент существует
            if (tail === t.next) //если он последний
            {
                tail = t //то переключаем указатель на последний элемент на текущий
                return t.next!!.data
            }
            else t = t.next //иначе ищем дальше
        }
        return 0
    }

    fun delEl(data: Int) //удаление элемента
    {
        if (head == null) //если список пуст -
            return  //ничего не делаем
        if (head === tail) { //если список состоит из одного элемента
            head = null //очищаем указатели начала и конца
            tail = null
            return  //и выходим
        }
        if (head?.data === data) { //если первый элемент - тот, что нам нужен
            head = head!!.next //переключаем указатель начала на второй элемент
            return  //и выходим
        }
        var t = head //иначе начинаем искать
        while (t?.next != null) { //пока следующий элемент существует
            if (t.next?.data == data) { //проверяем следующий элемент
                if (tail === t.next) //если он последний
                {
                    tail = t //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next?.next //найденный элемент выкидываем
                return  //и выходим
            }
            t = t.next //иначе ищем дальше
        }
    }

}