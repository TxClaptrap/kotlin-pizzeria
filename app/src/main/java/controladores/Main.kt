package controladores

import modelo.*

fun main() {
    // Ingredientes
    val queso = IngredienteDTO(id = 1, nombre = "Queso", alergenos = mutableListOf("Lactosa"))
    val tomate = IngredienteDTO(id = 2, nombre = "Tomate", alergenos = mutableListOf())
    val pepperoni = IngredienteDTO(id = 3, nombre = "Pepperoni", alergenos = mutableListOf("Sulfitos"))
    val albahaca = IngredienteDTO(id = 4, nombre = "Albahaca", alergenos = mutableListOf())

    // Pizzas
    val pizza1 = PizzaDTO(id = 1, nombre = "Margarita", precio = 8.5, size = SIZE.MEDIANO, listaIngredientes = mutableListOf(queso, tomate, albahaca))
    val pizza2 = PizzaDTO(id = 2, nombre = "Pepperoni", precio = 14.0, size = SIZE.GRANDE, listaIngredientes = mutableListOf(queso, tomate, pepperoni))
    val pizza3 = PizzaDTO(id = 3, nombre = "Veggie", precio = 7.5, size = SIZE.PEQUENO, listaIngredientes = mutableListOf(tomate, albahaca))

    // Lista de pizzas
    val listaPizzas = mutableListOf(pizza1, pizza2, pizza3)

    // Lista de alérgenos
    val listaAlergenos = listOf("Lactosa", "Sulfitos")

    // Prueba filtradoPizzas
    val pizzasFiltradasPorPrecio = filtradoPizzas(listaPizzas, min = 7.0, max = 9.0)
    println("Pizzas filtradas por precio entre 7.0 y 9.0:")
    pizzasFiltradasPorPrecio.forEach {println(it.nombre)}

    // Prueba alergiaFree
    val ingredientesSinAlergenos = alergiaFree(listaAlergenos, pizza1.listaIngredientes)
    println("\nIngredientes sin alérgenos de la pizza Margarita:")
    ingredientesSinAlergenos.forEach {println(it.nombre)}

    // Prueba ordenarPorPrecio
    val pizzasOrdenadasAsc = ordenarPorPrecio(listaPizzas, ascendente = true)
    println("\nPizzas ordenadas por precio ascendente:")
    pizzasOrdenadasAsc.forEach {println("${it.nombre}: ${it.precio}")}

    val pizzasOrdenadasDesc = ordenarPorPrecio(listaPizzas, ascendente = false)
    println("\nPizzas ordenadas por precio descendente:")
    pizzasOrdenadasDesc.forEach {println("${it.nombre}: ${it.precio}")}

    // Prueba contadPizzas
    val numPizzasConQueso = contadPizzas(listaPizzas, queso)
    println("\nNúmero de pizzas que contienen queso: $numPizzasConQueso")

    val numPizzasConTomate = contadPizzas(listaPizzas, tomate)
    println("Número de pizzas que contienen tomate: $numPizzasConTomate")
}
