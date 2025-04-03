package com.example.contactapp.model

class Contact {
    // private: Bảo vệ quyền truy cập
   private var id : Int
   private  var name : String
   private var phone : String // String hay Number tiết kiệm bộ nhớ hơn ? String tiết kiệm hơn

    constructor(id: Int, name: String, phone: String) {
         this.id = id
         this.name = name
         this.phone = phone
    }
}
