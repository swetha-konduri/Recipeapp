package swetha.example.recipeapp

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import swetha.example.recipeapp.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("RECIPE", Recipe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Recipe>("RECIPE")
        }

        recipe?.let {
            binding.detailName.text = it.name
            Glide.with(this).load(it.imageUrl).into(binding.detailImage)

            binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.ingredientsRecyclerView.adapter = StringAdapter(it.ingredients)

            binding.instructionsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.instructionsRecyclerView.adapter = StringAdapter(it.instructions)
        }
    }
}
