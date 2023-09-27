package com.example.project_one.modules

class Product {
    var name:String = ""
    var number:String = ""
    var quantity:String = ""
    var price:String = ""
    var id:String = ""

    constructor(name: String, number: String, quantity: String, price: String, id: String) {
        this.name = name
        this.number = number
        this.quantity = quantity
        this.price = price
        this.id = id
    }
    constructor()
}