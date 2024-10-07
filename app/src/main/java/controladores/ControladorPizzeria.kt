package controladores

import modelo.IngredienteDTO
import modelo.PizzaDTO


fun filtradoPizzas(listaPizzas:List<PizzaDTO>, min:Double = 7.0, max:Double = 10.0):List<PizzaDTO> {
    return listaPizzas.filter {pizza:PizzaDTO -> pizza.precio in min..max}
}

//fun filtradoPizzas2(listaPizzas:List<PizzaDTO>, min:Double = 7.0, max:Double = 10.0) = listaPizzas.filter {it.precio in min..max}

fun alergiaFree(listaAlergenos:List<String>, listaIngredientes:List<IngredienteDTO>): List<IngredienteDTO> {
    return listaIngredientes.filter {it.alergenos.none {it in listaAlergenos}}
}

fun ordenarPorPrecio(listaPizzas:List<PizzaDTO>, ascendente: Boolean): List<PizzaDTO> {
    return if (ascendente) listaPizzas.sortedBy {it.precio } else listaPizzas.sortedByDescending {it.precio}
}

/*fun contadPizzas(listaPizzas: List<PizzaDTO>, ingrediente: IngredienteDTO): Int {
    return listaPizzas.filter {pizza -> pizza.listaIngredientes.any {ingredientePizza -> ingredientePizza.nombre.equals(ingrediente.nombre)}}.count()
}*/

fun contadPizzas(listaPizzas: List<PizzaDTO>, ingrediente: IngredienteDTO):Int {
    return listaPizzas.count {it.listaIngredientes.contains(ingrediente) }
}

