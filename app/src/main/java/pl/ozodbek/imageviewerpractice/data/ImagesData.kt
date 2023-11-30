package pl.ozodbek.imageviewerpractice.data

data class ImagesData(
    val date: String,
    val description: String,
    val images: List<Images>
) {
    val imagePathModified: List<String>
        get() = images.map { it.imagePath }
}
