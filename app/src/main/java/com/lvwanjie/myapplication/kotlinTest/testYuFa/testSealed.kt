package com.lvwanjie.myapplication.kotlinTest.testYuFa

/**
 * 密封类
 */
sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Square(val sideLength: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
}

fun calculateArea(shape: Shape): Double = when (shape) {
    is Shape.Circle -> Math.PI * shape.radius * shape.radius
    is Shape.Square -> shape.sideLength * shape.sideLength
    is Shape.Rectangle -> shape.width * shape.height
}

val circle = Shape.Circle(5.0)
val square = Shape.Square(4.0)
val rectangle = Shape.Rectangle(6.0, 8.0)

//println(calculateArea(circle)) // 输出 78.53981633974483
//println(calculateArea(square)) // 输出 16.0
//println(calculateArea(rectangle)) // 输出 48.0
