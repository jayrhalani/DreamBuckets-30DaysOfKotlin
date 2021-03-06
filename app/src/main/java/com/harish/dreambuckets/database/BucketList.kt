package com.harish.dreambuckets.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "bucket_list")
data class BucketList(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "bucket_name")
    var bucketName: String,
    @ColumnInfo(name = "bucket_thoughts")
    var bucketThoughts : String,
    @ColumnInfo(name = "bucket_category")
    var category: String,
    @ColumnInfo(name = "traget_date")
    var bucketTargetDate: String,
    @ColumnInfo(name = "image_uri")
    var bucketImageUri: String,
    @ColumnInfo(name = "dream_level")
    var dreamLevel: String,
    @ColumnInfo(name = "isAccompolished")
    var isAccompolished: Int
){
    @Ignore
    constructor(bucketName: String, bucketThoughts: String,
                bucketCategory: String, targetDate: String, bucketImageUri: String,
                dreamLevel: String, isAccompolished:Int) : this(
            id=0, bucketName = bucketName,bucketThoughts = bucketThoughts,
        category = bucketCategory, bucketTargetDate = targetDate, bucketImageUri = bucketImageUri,
        dreamLevel = dreamLevel,isAccompolished = isAccompolished)


}
