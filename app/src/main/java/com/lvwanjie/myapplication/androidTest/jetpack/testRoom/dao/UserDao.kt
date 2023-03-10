package com.lvwanjie.myapplication.androidTest.jetpack.testRoom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lvwanjie.myapplication.androidTest.jetpack.testRoom.entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM user")
    fun getUsers():List<User>

}