package com.example.vaialipramim.dominios

data class Token(
    var email : String,
    var code : String
){
    constructor(email: String):this(
        email = email, code = ""
    )

    override fun toString(): String {
        return "Token(email='$email', code='$code')"
    }


}
