package com.example.mocklist.viewobservers

import android.net.Uri
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.api.load
import coil.decode.SvgDecoder
import coil.transform.RoundedCornersTransformation
import com.example.mocklist.App
import com.example.mocklist.R
import timber.log.Timber


/**
 * set bitmap to imageview
 */
@BindingAdapter("imageDrawableSrc")
fun bitmapSrc(imageView: AppCompatImageView, imageDrawable: Int?) {
    val imageLoader = ImageLoader(imageView.context) {
        componentRegistry {
            add(SvgDecoder(imageView.context))
        }
    }
    imageDrawable?.let { drawable ->
        imageView.load(drawable, imageLoader) {
            error(R.drawable.placeholder_for_missing_posters)
        }
    }
}

@BindingAdapter("hasFixedSize")
fun setFixedSize(recycleView: RecyclerView, fixed: Boolean) {
    recycleView.setHasFixedSize(fixed)
}


@BindingAdapter("loadImageFromURL")
fun loadImagefromURL(imageView: ImageView, imageUrl: String?) {
    val imageLoader = ImageLoader(imageView.context)

    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader){
            placeholder(R.drawable.placeholder_for_missing_posters  )
            error(R.drawable.placeholder_for_missing_posters)
            crossfade(false)
            transformations(RoundedCornersTransformation(20f))
        }
    }
}

@BindingAdapter("upvotesImageUrl")
fun upvotesImageUrl(imageView: ImageView, imageUrl: String?) {
    val imageLoader = ImageLoader(imageView.context)

    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            error(R.drawable.placeholder_for_missing_posters)
            placeholder(R.drawable.placeholder_for_missing_posters)
            crossfade(false)
            transformations(RoundedCornersTransformation(32f))
        }
    }
}

@BindingAdapter("profileImageUrl")
fun profileImageUrl(imageView: ImageView, imageUrl: String?) {
    val imageLoader = ImageLoader(imageView.context)

    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            error(R.drawable.placeholder_for_missing_posters)
            crossfade(false)
            transformations(RoundedCornersTransformation(32f))
        }
    }
}

@BindingAdapter("commentImageUrl")
fun commentImageUrl(imageView: ImageView, imageUrl: String?) {

    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            crossfade(false)
            error(R.drawable.placeholder_for_missing_posters)
            transformations(RoundedCornersTransformation(32f))
        }
    }
}

@BindingAdapter("commentBottomSheetDialogImageUrl")
fun commentBottomSheetDialogImageUrl(imageView: ImageView, imageUrl: String?) {

    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            crossfade(false)
            error(R.drawable.placeholder_for_missing_posters)
            transformations(RoundedCornersTransformation(30f))
        }
    }
}


@BindingAdapter("addItemDecoration")
fun addItemDecorationForRecycleView(recyclerView: RecyclerView, layout: Int) {
    val dividerItemDecoration = DividerItemDecoration(
        recyclerView.context,
        LinearLayout.VERTICAL
    )
    dividerItemDecoration.setDrawable(recyclerView.context.getDrawable(layout)!!)
    recyclerView.addItemDecoration(dividerItemDecoration)
}

@BindingAdapter("loadGifUrl")
fun loadGifUrl(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            crossfade(false)
            error(R.drawable.placeholder_for_missing_posters)
            Timber.d("image url $url")
        }
    }

}

@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView, @DrawableRes resource: Int) {
    resource?.let { url ->
        imageView.load(url, App.coilImageLoader) {
            crossfade(false)
            error(R.drawable.placeholder_for_missing_posters)
            Timber.d("image url $url")
        }
    }
}


@BindingAdapter("loadImageFromURI")
fun setImageUri(imageView: ImageView, imageUri: Uri) {
    imageUri.let { uri ->
        imageView.load(uri, App.coilImageLoader) {
            crossfade(false)
            error(R.drawable.placeholder_for_missing_posters)
            Timber.d("image uri $uri")
        }
    }
}


