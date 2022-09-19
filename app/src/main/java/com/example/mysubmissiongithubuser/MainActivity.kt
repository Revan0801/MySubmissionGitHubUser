package com.example.mysubmissiongithubuser

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysubmissiongithubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvGitUser : RecyclerView
    private val list = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Github User's"

        rvGitUser = findViewById(R.id.rv_gitUser)
        rvGitUser.setHasFixedSize(true)

        list.addAll(listUsername)
        showRecyclerList()

    }

    private val listUsername: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataUserName = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)

            val listUser = ArrayList<User>()

            for (i in dataUserName.indices) {
                val user = User(dataUserName[i], dataName[i], dataAvatar.getResourceId(i, -1),
                dataFollower[i], dataFollowing[i], dataCompany[i], dataLocation[i], dataRepository[i])

                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {

        val listUserAdapter = ListUserAdapter(list)
        rvGitUser.adapter = listUserAdapter

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvGitUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvGitUser.layoutManager = LinearLayoutManager(this)
        }

        listUserAdapter.setOnItemCallBack(object : ListUserAdapter.OnItemClickCallBack {

            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailUser::class.java)
                intentToDetail.putExtra(DetailUser.EXTRA_USER, data)
                startActivity(intentToDetail)
            }
        })
    }
}