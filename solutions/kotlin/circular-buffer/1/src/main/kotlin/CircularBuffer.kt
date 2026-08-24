import kotlin.collections.ArrayDeque

class EmptyBufferException : Exception()

class BufferFullException: Exception()

class CircularBuffer<T>(val capacity: Int) {
    var array: ArrayDeque<T> = ArrayDeque(capacity)

    fun read() : T {
        if(array.isEmpty()) {
            throw EmptyBufferException()
        }
        return array.removeFirst()
    }

    fun write(value: T) {
        if(array.size >= capacity) {
            throw BufferFullException()
        }
        array.addLast(value)
    }

    fun overwrite(value: T) {
        if(array.size >= capacity) {
            array.removeFirst()
        }
        array.addLast(value)
    }

    fun clear() {
        array.clear()
    }
}