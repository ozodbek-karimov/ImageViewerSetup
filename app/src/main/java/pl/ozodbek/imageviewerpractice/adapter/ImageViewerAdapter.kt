package pl.ozodbek.imageviewerpractice.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pl.ozodbek.imageviewerpractice.data.ImagesData
import pl.ozodbek.imageviewerpractice.databinding.Viewpager2ItemRowBinding
import pl.ozodbek.imageviewerpractice.util.buildImageViewer
import pl.ozodbek.imageviewerpractice.util.loadImage
import pl.ozodbek.imageviewerpractice.util.onClick
import pl.ozodbek.imageviewerpractice.util.viewBinding


@SuppressLint("SetTextI18n")
class ImageViewerAdapter(
    private val images: List<String>,
    private val commonPosts: ImagesData?,
    private val viewPager2: ViewPager2,
) : RecyclerView.Adapter<ImageViewerAdapter.ImageViewHolder>() {

    private val context: Context by lazy { viewPager2.context }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(parent.viewBinding(Viewpager2ItemRowBinding::inflate))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = images[position]

        holder.bindImage(imageUrl, position)

        holder.itemView.onClick {

            buildImageViewer(
                context,
                images,
                viewPager2,
                position,
                commonPosts?.date,
                commonPosts?.description
            )

        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                holder.binding.imageCounterTv.text = "${position + 1}/${images.size}"
            }
        })
    }

    override fun getItemCount() = images.size

    inner class ImageViewHolder(val binding: Viewpager2ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindImage(imageUrl: String, position: Int) {
            binding.imageViewViewPager2.loadImage(imageUrl)
            binding.imageCounterTv.text = "${position + 1}/${images.size}"
        }
    }
}
