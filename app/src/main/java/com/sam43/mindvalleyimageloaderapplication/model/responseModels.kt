package com.sam43.mindvalleyimageloaderapplication.model
import com.google.gson.annotations.SerializedName

data class GenericReS(
    var isSuccess: Boolean? = true,
    @SerializedName("categories")
    val resCategories: List<Category?>? = null,
    @SerializedName("color")
    val resColor: String? = null,
    @SerializedName("created_at")
    val resCreatedAt: String? = null,
    @SerializedName("current_user_collections")
    val resCurrentUserCollections: List<Any?>? = null,
    @SerializedName("height")
    val resHeight: Int? = null,
    @SerializedName("id")
    val resId: String? = null,
    @SerializedName("liked_by_user")
    val resLikedByUser: Boolean? = null,
    @SerializedName("likes")
    val resLikes: Int? = null,
    @SerializedName("links")
    val resLinks: LinksX? = null,
    @SerializedName("urls")
    val resUrls: Urls? = null,
    @SerializedName("user")
    val resUser: User? = null,
    @SerializedName("width")
    val resWidth: Int? = null
)

data class Category(
    @SerializedName("id")
    val resId: Int? = null,
    @SerializedName("links")
    val resLinks: Links? = null,
    @SerializedName("photo_count")
    val resPhotoCount: Int? = null,
    @SerializedName("title")
    val resTitle: String? = null
)

data class Links(
    @SerializedName("photos")
    val resPhotos: String? = null,
    @SerializedName("self")
    val resSelf: String? = null
)

data class LinksX(
    @SerializedName("download")
    val resDownload: String? = null,
    @SerializedName("html")
    val resHtml: String? = null,
    @SerializedName("self")
    val resSelf: String? = null
)

data class Urls(
    @SerializedName("full")
    val resFull: String? = null,
    @SerializedName("raw")
    val resRaw: String? = null,
    @SerializedName("regular")
    val resRegular: String? = null,
    @SerializedName("small")
    val resSmall: String? = null,
    @SerializedName("thumb")
    val resThumb: String? = null
)

data class User(
    @SerializedName("id")
    val resId: String? = null,
    @SerializedName("links")
    val resLinks: LinksXX? = null,
    @SerializedName("name")
    val resName: String? = null,
    @SerializedName("profile_image")
    val resProfileImage: ProfileImage? = null,
    @SerializedName("username")
    val resUsername: String? = null
)

data class LinksXX(
    @SerializedName("html")
    val resHtml: String? = null,
    @SerializedName("likes")
    val resLikes: String? = null,
    @SerializedName("photos")
    val resPhotos: String? = null,
    @SerializedName("self")
    val resSelf: String? = null
)

data class ProfileImage(
    @SerializedName("large")
    val resLarge: String? = null,
    @SerializedName("medium")
    val resMedium: String? = null,
    @SerializedName("small")
    val resSmall: String? = null
)