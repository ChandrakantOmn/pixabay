package com.demo.pagedemo.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class APIResponse(
    var hits: List<Hit?>?,
    var total: Int?, // 20533
    var totalHits: Int? // 500
) {
    data class Hit(
        var comments: Int?, // 199
        var downloads: Int?, // 263445
        var favorites: Int?, // 1377
        var id: Int?, // 2083492
        var imageHeight: Int?, // 3008
        var imageSize: Int?, // 4130948
        var imageWidth: Int?, // 4928
        var largeImageURL: String?, // https://pixabay.com/get/54e0dd404e5bae14f6da8c7dda793678163ed7e656536c48702673dd9145c059b1_1280.jpg
        var likes: Int?, // 1551
        var pageURL: String?, // https://pixabay.com/photos/cat-young-animal-curious-wildcat-2083492/
        var previewHeight: Int?, // 91
        var previewURL: String?, // https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_150.jpg
        var previewWidth: Int?, // 150
        var tags: String?, // cat, young animal, curious
        var type: String?, // photo
        var user: String?, // susannp4
        @SerializedName("user_id")
        var userId: Int?, // 1777190
        var userImageURL: String?, // https://cdn.pixabay.com/user/2015/12/16/17-56-55-832_250x250.jpg
        var views: Int?, // 521009
        var webformatHeight: Int?, // 390
        var webformatURL: String?, // https://pixabay.com/get/54e0dd404e5bae14f1dc84609629317d1436dde0514c704c7c2772d29f48c451_640.jpg
        var webformatWidth: Int? // 640
    ): Serializable {
    }
}