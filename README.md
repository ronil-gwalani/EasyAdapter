# 🧩 EasyAdapter – Simplify RecyclerView Adapters

**EasyAdapter** is a lightweight Android library that allows developers to quickly bind any data list to a `RecyclerView` using ViewBinding, without having to create repetitive adapter or ViewHolder boilerplate code.

---

## ✨ Features

- 🔁 Generic, reusable `RecyclerView` adapter setup  
- 🛠️ Zero custom adapter class needed  
- 🔍 Full access to binding, model, and index in a clean lambda block  
- ➕ Utility functions to update, remove, or fetch items at runtime  
- 🧵 Built with **Kotlin**, using **ViewBinding**  
- 📱 Works out-of-the-box with any `RecyclerView`  

---

## 🎯 Purpose

Creating a new `RecyclerView.Adapter` for every list felt redundant. This library was born out of the need to:  
- Reduce boilerplate  
- Speed up development  
- Write less, do more  

**EasyAdapter** lets you focus on binding logic while it handles the heavy lifting in the background.

---

## 🛠️ Tech Stack

- 🧵 Kotlin  
- 🖼️ ViewBinding  
- 🧩 RecyclerView  
- 💡 ConstraintLayout (recommended for item layouts)  

---


## 🖼️ Screenshots

| Recycler View Of Users | Scrolling of Users |
|-------------|------------------|
| ![Recycler View Of Users](https://github.com/ronil-gwalani/EasyRecyclerView/blob/main/screenshots/image.jpg) | ![](https://github.com/ronil-gwalani/EasyRecyclerView/blob/main/screenshots/video.gif) 

---



## 🚀 Getting Started

### Step 1: Add Dependency


```kotlin
implementation ("com.github.ronil-gwalani:easyadapter:1.0.1")
```

### Step 2: Initialize Your RecyclerView

```kotlin
val adapter = binding.recycler.setEasyAdapter<UserRowBinding, UserModel>(
    list = userList
) { binding, model, index ->
    binding.tvUserName.text = model.name
    binding.tvUserId.text = model.userID
    binding.tvEmail.text = model.email
    binding.tvGender.text = model.gender
    binding.tvAddress.text = model.address
    binding.tvContact.text = model.contactNum

    binding.root.setOnClickListener {
        Toast.makeText(this@MainActivity, model.name, Toast.LENGTH_SHORT).show()
    }
}
```

---

## 🧰 Adapter Utilities

```kotlin
adapter.getList()              // Get the current list  
adapter.clearList()            // Remove all items  
adapter.addItem(userModel)     // Add a single item  
adapter.addMoreItems(listOf(...))  // Add multiple items  
adapter.removeItem(index = 2)  // Remove item by index  
adapter.removeItem(userModel)  // Remove item by reference  
adapter.updateItem(updatedUser, index = 4)  // Update item  
```

---

## 📂 Sample Model

```kotlin
data class UserModel(
    val name: String,
    val userID: String,
    val email: String,
    val contactNum: String,
    val address: String,
    val gender: String,
)
```

---

## 💬 Feedback & Contributions

Suggestions and contributions are always welcome!  
Feel free to open issues or pull requests to improve this project.

---

## 🙋 About Me

- 🌐 [ronildeveloper.in](https://ronildeveloper.in)  
- 💼 [LinkedIn – Ronil Gwalani](https://www.linkedin.com/in/ronil-gwalani)  
- 📄 [Download My Resume](https://ronildeveloper.in/files/Ronil-CV.pdf)

---

## 📜 License

This project is open-source and free to use.  
Released under the [MIT License](LICENSE).
