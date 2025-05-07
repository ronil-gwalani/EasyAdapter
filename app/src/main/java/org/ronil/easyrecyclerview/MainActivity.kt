package org.ronil.easyrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.ronil.easyrecyclerview.databinding.ActivityMainBinding
import org.ronil.easyrecyclerview.databinding.UserRowBinding
import org.ronil.library.setEasyAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        data class UserModel(val username: String, val userID: String)

        val list =
            listOf(
                UserModel(userID = "1", username = "Ronil"),
                UserModel(userID = "2", username = "Kapil"),
                UserModel(userID = "3", username = "Kartik"),
                UserModel(userID = "4", username = "2e3r4t5"),
                UserModel(userID = "5", username = "wsdefrgth"),
                UserModel(userID = "6", username = "e3r4t5"),
                UserModel(userID = "7", username = "wdefrgthy"),
            )

        val adapter = binding.recycler.setEasyAdapter<UserRowBinding, UserModel>(
            list = list,
        ) { binding, model, index ->
            binding.root.setOnClickListener {
                Toast.makeText(this@MainActivity, model.username, Toast.LENGTH_SHORT).show()
            }
            binding.txt1.text = model.username
            binding.text2.text = model.userID
        }
        adapter.getList()
        adapter.clearList()
        adapter.addItem(UserModel(userID = "2", username = "New Name"))
        adapter.removeItem(list[3])
        adapter.updateItem(list[3].copy(username = "Updated Name"), 3)
        adapter.addMoreItems(
            listOf(
                UserModel(userID = "77", username = "987654"),
                UserModel(userID = "87", username = "jhgfds"),
                UserModel(userID = "098", username = "ohuigyftdres"),
            )
        )
        adapter.removeItem(1)
    }


}
