package com.example.myapp2

class Coffe {
    private var quantity: Int? = 0
    var hasWhippingCream: Boolean? = false
    var hasChocolate: Boolean? = false

    fun getQuantity(): String? {
        return quantity.toString()
    }

    fun getWhippingCream(): String? {
        return if (hasWhippingCream == true) {
            "True"
        } else {
            "False"
        }
    }

    fun getChocolate(): String? {
        return if (hasChocolate == true) {
            "True"
        } else {
            "False"
        }
    }

    fun increment(){
        quantity = quantity?.plus(1)
    }
    fun decrement(){

        quantity = quantity?.minus(1)
    }

    fun setCream(boolean: Boolean): Boolean? {
        if(boolean == false){
            hasWhippingCream = false
        }
        else{
            hasWhippingCream = true
        }
        return hasWhippingCream
    }
    fun setChocolate(boolean: Boolean): Boolean? {
        if(boolean == false){
            hasChocolate = false
        }
        else{
            hasChocolate = true
        }
        return hasChocolate
    }
    fun computeOrder(): String? {
        var totalCost = quantity!! * 4.00
        if (hasWhippingCream == true) {
            totalCost += quantity!! * .50
        }
        if (hasChocolate == true) {
            totalCost += quantity!! * 1.00
        }
        return totalCost.toString()
    }
}