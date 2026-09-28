package swetha.example.recipeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import swetha.example.recipeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipes = listOf(
            Recipe(
                1,
                "Spaghetti Carbonara",
                "https://www.giallozafferano.it/images/219-21928/Spaghetti-alla-Carbonara_650x433_wm.jpg",
                listOf("Spaghetti", "Eggs", "Pecorino Romano", "Guanciale", "Black pepper"),
                listOf("Boil pasta", "Fry guanciale", "Mix eggs and cheese", "Combine everything")
            ),
            Recipe(
                2,
                "Chicken Tikka Masala",
                "https://www.modernhoney.com/wp-content/uploads/2018/03/Chicken-Tikka-Masala-1.jpg",
                listOf("Chicken", "Yogurt", "Garam Masala", "Tomatoes", "Cream"),
                listOf("Marinate chicken", "Grill chicken", "Prepare sauce", "Simmer chicken in sauce")
            ),
            Recipe(
                3,
                "Caprese Salad",
                "https://www.thespruceeats.com/thmb/9W6YFm8U9G4JzVz_Y_X5m7M_YyY=/1500x1000/filters:no_upscale():max_bytes(150000):strip_icc()/caprese-salad-with-balsamic-glaze-recipe-2216091-hero-01-0708d3e91d3e4d2a9b6d8d6d6d6d6d6d.jpg",
                listOf("Tomatoes", "Mozzarella", "Basil", "Olive oil", "Balsamic glaze"),
                listOf("Slice tomatoes and mozzarella", "Layer them with basil", "Drizzle with oil and glaze")
            )
        )

        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.recipeRecyclerView.adapter = RecipeAdapter(recipes) { recipe ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE", recipe)
            startActivity(intent)
        }
    }
}
