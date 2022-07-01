package com.andrew.restaurantmenu

import android.media.Image

class Foods {
    var name: String? = null
    var des: String? = null
    var image: Int? = null

    constructor(name:String, des:String, image: Int){
        this.name = name
        this.des = des
        this.image = image
    }

}