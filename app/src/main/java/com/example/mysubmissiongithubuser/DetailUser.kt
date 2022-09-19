package com.example.mysubmissiongithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mysubmissiongithubuser.databinding.ActivityDetailUserBinding
import java.lang.Exception

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

        try {
            val imgAvatar: ImageView = findViewById(R.id.img_itemAvatar)
            val tvUserName: TextView = findViewById(R.id.tv_itemUsername)
            val tvName: TextView = findViewById(R.id.tv_itemName)
            val tvFollower: TextView = findViewById(R.id.tv_follower)
            val tvFollowing: TextView = findViewById(R.id.tv_following)
            val tvCompany: TextView = findViewById(R.id.tv_company)
            val tvLocation: TextView = findViewById(R.id.tv_location)
            val tvRepository: TextView = findViewById(R.id.tv_repository)

            val user: User? = intent.getParcelableExtra(EXTRA_USER)

            if (user != null) {
                val textUserName = user.username
                val textName = user.name
                val igAvatar = user.avatar
                val textFollower = user.follower
                val textFollowing = user.following
                val textCompany = user.company
                val textLocation = user.location
                val textRepository = user.repository

                imgAvatar.setImageResource(igAvatar)
                tvUserName.text = textUserName
                tvName.text = textName
                tvFollower.text = textFollower
                tvFollowing.text = textFollowing
                tvCompany.text = textCompany
                tvLocation.text = textLocation
                tvRepository.text = textRepository
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}