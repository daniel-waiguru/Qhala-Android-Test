package tech.danielwaiguru.qhalamovies.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import tech.danielwaiguru.qhalamovies.common.extensions.loadImage

@BindingAdapter("loadImageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        view.loadImage(imageUrl)
    }
}