package org.ronil.easyrecyclerview

/*
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.ronil.easyrecyclerview.databinding.UserRowBinding
import org.ronil.library.setEasyAdapter

object setUpData{
    private fun getDuymmyUsers(): List<UserModel> {
        return listOf(
            UserModel(
                "Kapil Sharma",
                "1",
                "kapilsharma@gmail.com",
                "7979976999",
                "Sector 11, Malviya Nagar, Jaipur, Rajasthan",
                "Male"
            ),
            UserModel(
                "Priya Mehta",
                "2",
                "priyamehta@gmail.com",
                "9812345670",
                "MG Road, Indore, Madhya Pradesh",
                "Female"
            ),
            UserModel(
                "Rohit Verma",
                "3",
                "rohitv88@gmail.com",
                "9823456781",
                "Shivaji Nagar, Pune, Maharashtra",
                "Male"
            ),
            UserModel(
                "Anjali Sharma",
                "4",
                "anjali.s@gmail.com",
                "9876543210",
                "Civil Lines, Delhi",
                "Female"
            ),
            UserModel(
                "Amitabh Joshi",
                "5",
                "amitabhjoshi@gmail.com",
                "9798989898",
                "Sector 22, Chandigarh",
                "Male"
            ),
            UserModel(
                "Sneha Kapoor",
                "6",
                "snehakp@hotmail.com",
                "9933445566",
                "Banjara Hills, Hyderabad, Telangana",
                "Female"
            ),
            UserModel(
                "Manoj Tiwari",
                "7",
                "manojtiwari@yahoo.com",
                "9123456789",
                "Ashok Nagar, Patna, Bihar",
                "Male"
            ),
            UserModel(
                "Ritika Singh",
                "8",
                "ritikasingh@gmail.com",
                "9865321478",
                "Salt Lake City, Kolkata, West Bengal",
                "Female"
            ),
            UserModel(
                "Vikas Gupta",
                "9",
                "vikasg999@gmail.com",
                "9988776655",
                "Rajendra Nagar, Lucknow, Uttar Pradesh",
                "Male"
            ),
            UserModel(
                "Neha Desai",
                "10",
                "nehadesai@outlook.com",
                "9012345678",
                "Ellis Bridge, Ahmedabad, Gujarat",
                "Female"
            ),
            UserModel(
                "Raj Malhotra",
                "11",
                "raj.malhotra@gmail.com",
                "9321654789",
                "Hinjewadi, Pune, Maharashtra",
                "Male"
            ),
            UserModel(
                "Ishita Sen",
                "12",
                "ishitasen@gmail.com",
                "8945123654",
                "New Alipore, Kolkata, West Bengal",
                "Female"
            ),
            UserModel(
                "Sandeep Reddy",
                "13",
                "sandeepreddy@gmail.com",
                "9765432198",
                "Jubilee Hills, Hyderabad, Telangana",
                "Male"
            ),
            UserModel(
                "Kavita Nair",
                "14",
                "kavitanair@gmail.com",
                "9873214560",
                "Vile Parle, Mumbai, Maharashtra",
                "Female"
            ),
            UserModel(
                "Harsh Patel",
                "15",
                "harshpatel@gmail.com",
                "9988771234",
                "Navrangpura, Ahmedabad, Gujarat",
                "Male"
            ),
            UserModel(
                "Meena Kumari",
                "16",
                "meenak@gmail.com",
                "9845123678",
                "Anna Nagar, Chennai, Tamil Nadu",
                "Female"
            ),
            UserModel(
                "Arjun Singh",
                "17",
                "arjunsingh@yahoo.com",
                "9321658794",
                "Gomti Nagar, Lucknow, Uttar Pradesh",
                "Male"
            ),
            UserModel(
                "Pooja Rani",
                "18",
                "poojarani@gmail.com",
                "9911223344",
                "Model Town, Delhi",
                "Female"
            ),
            UserModel(
                "Nikhil Jain",
                "19",
                "nikhil.jain@gmail.com",
                "9845098450",
                "Tilak Nagar, Jaipur, Rajasthan",
                "Male"
            ),
            UserModel(
                "Divya Bhatt",
                "20",
                "divyabhatt@gmail.com",
                "9723456123",
                "Sadar Bazar, Agra, Uttar Pradesh",
                "Female"
            )
        )

    }

     fun setAdapter(recycler: RecyclerView) {

        val list = getDuymmyUsers()

        val adapter =
            recycler.setEasyAdapter<UserRowBinding, UserModel>(
                list = list,
            ) { binding, model, index ->
                binding.root.setOnClickListener {
                    Toast.makeText(recycler.context, model.name, Toast.LENGTH_SHORT).show()
                }
                binding.tvUserName.text = model.name
                binding.tvUserId.text = model.userID
                binding.tvEmail.text = model.email
                binding.tvGender.text = model.gender
                binding.tvAddress.text = model.address
                binding.tvContact.text = model.contactNum
            }
        adapter.getList()
        adapter.clearList()
        adapter.addItem(
            UserModel(
                "Rohit Verma",
                "3",
                "rohitv88@gmail.com",
                "9823456781",
                "Shivaji Nagar, Pune, Maharashtra",
                "Male"
            ),
        )
        adapter.removeItem(list[3])
        adapter.updateItem(list[3].copy(name = "Updated Name"), 3)
        adapter.addMoreItems(
            listOf(
                UserModel(
                    "Amitabh Joshi",
                    "5",
                    "amitabhjoshi@gmail.com",
                    "9798989898",
                    "Sector 22, Chandigarh",
                    "Male"
                ),
                UserModel(
                    "Sneha Kapoor",
                    "6",
                    "snehakp@hotmail.com",
                    "9933445566",
                    "Banjara Hills, Hyderabad, Telangana",
                    "Female"
                ),
                UserModel(
                    "Manoj Tiwari",
                    "7",
                    "manojtiwari@yahoo.com",
                    "9123456789",
                    "Ashok Nagar, Patna, Bihar",
                    "Male"
                ),
            )
        )
        adapter.removeItem(1)

    }

    data class UserModel(
        val name: String,
        val userID: String,
        val email: String,
        val contactNum: String,
        val address: String,
        val gender: String,
    )
}*/
