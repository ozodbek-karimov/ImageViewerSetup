package pl.ozodbek.imageviewerpractice.util

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import coil.size.ViewSizeResolver
import pl.ozodbek.imageviewerpractice.R

fun ImageView.loadImage(image: String) {
    this.load(image.ifEmpty { R.drawable.ic_error_placeholder }) {
        crossfade(true)
        placeholder(R.drawable.ic_error_placeholder)
        error(R.drawable.ic_error_placeholder)
        size(ViewSizeResolver(this@loadImage))
        memoryCachePolicy(CachePolicy.ENABLED)
        placeholder(R.drawable.ic_error_placeholder)
        error(R.drawable.ic_error_placeholder)
        size(ViewSizeResolver(this@loadImage))
        diskCachePolicy(CachePolicy.ENABLED)

    }
}