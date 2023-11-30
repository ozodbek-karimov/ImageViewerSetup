package pl.ozodbek.imageviewerpractice.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import com.stfalcon.imageviewer.StfalconImageViewer
import pl.ozodbek.imageviewerpractice.databinding.ImageViewerToolbarBinding

@SuppressLint("SetTextI18n")
fun buildImageViewer(
    context: Context,
    images: List<String>,
    viewPager2: ViewPager2,
    position: Int,
    date: String?,
    description: String?
    ): StfalconImageViewer.Builder<String> {
    val binding = ImageViewerToolbarBinding.inflate(LayoutInflater.from(context))

    return StfalconImageViewer.Builder(context, images) { imageView, image ->
        imageView.loadImage(image)
    }.apply {
        withStartPosition(position)
        withImageMarginPixels(100)
        withContainerPaddingPixels(70)
        withHiddenStatusBar(false)
        allowZooming(true)
        allowSwipeToDismiss(true)
        withDismissListener {}
        withImageChangeListener { positionImage ->
            binding.imageCounterTv.text = "${positionImage + 1}/${images.size}"
            viewPager2.currentItem = positionImage
        }
        withOverlayView(binding.root)
    }.also { builder ->
        val falcon = builder.show()
        binding.backButton.onClick {
            falcon.dismiss()
        }

        binding.imageCounterTv.text = "${position + 1}/${images.size}"
        binding.dataTv.text = date
        binding.descriptionToolbarTextview.text = description
        binding.descriptionToolbarTextview.isSelected = true
    }
}

