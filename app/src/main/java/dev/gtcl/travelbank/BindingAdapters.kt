package dev.gtcl.travelbank

import android.annotation.SuppressLint
import android.text.SpannableString
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.gtcl.travelbank.domain.model.Expense
import dev.gtcl.travelbank.presentation.expense.overview.adapter.ExpenseAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let{
        Glide.with(imgView.context)
            .load(it.toUri().buildUpon().scheme("https").build())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("imageUrlRoundedCorners")
fun bindImageWithRoundedCorners(imageView: ImageView, imgUrl: String?){
    imageView.clipToOutline = true
    bindImage(imageView, imgUrl)
}

@BindingAdapter("expenses")
fun bindExpenses(recyclerView: RecyclerView, expenses: List<Expense>?){
    expenses?.let {
        val adapter = recyclerView.adapter as ExpenseAdapter
        adapter.submitList(it)
    }
}

@SuppressLint("StringFormatMatches")
@BindingAdapter("total")
fun bindTotal(textView: TextView, total: Float){
    val text = textView.context.getString(R.string.total_with_value, total)
    textView.text = text
}