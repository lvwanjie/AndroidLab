package com.lvwanjie.myapplication.androidTest.jetpack.testRoom.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User (@PrimaryKey val id:Int,
                 val name:String,
                 var age:Int)