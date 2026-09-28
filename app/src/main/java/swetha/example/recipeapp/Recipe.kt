package swetha.example.recipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>
) : Parcelable
