package tech.danielwaiguru.qhalamovies.common.extensions

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import tech.danielwaiguru.qhalamovies.R

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.ic_broken_image)
        .into(this)
}
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}