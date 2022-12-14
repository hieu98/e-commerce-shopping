package com.example.e_commerceshopping.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.os.bundleOf
import java.io.File
import java.io.Serializable

object AppUtils {
    const val READ_PERMISSION = Manifest.permission.READ_EXTERNAL_STORAGE
    const val WRITE_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE
    const val CAMERA_PERMISSION = Manifest.permission.CAMERA
    const val REQUEST_CODE_REQUEST_PERMISSION = 999

    fun openBrowser(url: String, context: Context) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(browserIntent)
    }

    fun dpToPx(context: Context, dp:Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }

    @SuppressLint("Range")
    fun getContentType(contentResolver: ContentResolver, uri: Uri?): String? {
        var type: String? = null
        val cursor = contentResolver.query(uri!!, null, null, null, null)
        try {
            if (cursor != null) {
                cursor.moveToFirst()
                type = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE))
                cursor.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return if (TextUtils.isEmpty(type)) "application/octet-stream" else type
    }

    private fun getCursor(uri: Uri, contentResolver: ContentResolver): Cursor? {
        return queryLocal(uri,contentResolver ,null,null, null)
    }

    fun checkPermissionGrant(per : List<String>, context: Context) : Boolean{
        var isGrant = true
        per.forEach {
            isGrant = ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
        return isGrant
    }

    private fun queryLocal(
        uri: Uri,
        contentResolver: ContentResolver,
        selection: String?,
        offset: Int?,
        limit: Int?
    ): Cursor? {

        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            var query = "${MediaStore.Files.FileColumns.DATE_MODIFIED} desc"
            if (limit != null) {
                query += " limit $limit offset $offset"
            }
            contentResolver.query(
                uri,
                PROJECTION,
                selection,
                null,
                query
            )
        } else {
            contentResolver.query(
                uri,
                null,
                bundleOf(
                    ContentResolver.QUERY_ARG_SQL_SELECTION to selection,
                    ContentResolver.QUERY_ARG_LIMIT to limit,
                    ContentResolver.QUERY_ARG_OFFSET to offset,
                    ContentResolver.QUERY_ARG_SORT_COLUMNS to arrayOf(MediaStore.Files.FileColumns.DATE_MODIFIED),
                    ContentResolver.QUERY_ARG_SORT_DIRECTION to ContentResolver.QUERY_SORT_DIRECTION_DESCENDING
                ),
                null,
            )
        }
    }

    data class Fourth<out A, out B, out C, out D>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D
    ) : Serializable {
        override fun toString(): String = "($first, $second, $third, $fourth)"
    }

    fun <T> Fourth<T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth)

    private val PROJECTION = arrayOf(
        MediaStore.Files.FileColumns._ID,
        MediaStore.Files.FileColumns.DATE_ADDED,
        MediaStore.Files.FileColumns.DATE_MODIFIED,
        MediaStore.Files.FileColumns.DISPLAY_NAME,
        MediaStore.Files.FileColumns.SIZE,
        MediaStore.Files.FileColumns.DATE_TAKEN
    )

}