package pl.ozodbek.imageviewerpractice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.ozodbek.imageviewerpractice.adapter.ImageViewerAdapter
import pl.ozodbek.imageviewerpractice.data.Images
import pl.ozodbek.imageviewerpractice.data.ImagesData
import pl.ozodbek.imageviewerpractice.databinding.ActivityMainBinding
import pl.ozodbek.imageviewerpractice.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var imageViewerAdapter: ImageViewerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val imagesPath = listOf(
            "https://picsum.photos/100/300",
            "https://picsum.photos/200/460",
            "https://picsum.photos/300/400",
            "https://picsum.photos/400/400",
            "https://picsum.photos/500/400",
            "https://picsum.photos/300/400",
            "https://picsum.photos/200/400"
        )

        val dummyDataList = ImagesData(
            date = "2023-01-01",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            imagesPath.map { Images(it) }
        )


        imageViewerAdapter = ImageViewerAdapter(dummyDataList.imagePathModified, dummyDataList, binding.viewPager2)

        binding.viewPager2.adapter = imageViewerAdapter
    }

}