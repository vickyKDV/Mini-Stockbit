package com.vickykdv.mystockbit.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.vickykdv.mystockbit.R

object ExtentionUtils {

    fun Context.showToast(text:String? = "", isLongDuration:Boolean = false){
        if(isLongDuration)
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun View.onClick(
        click:() -> Unit
    ){
        setOnClickListener {
            click.invoke()
        }
    }

    fun View.hide(){
        visibility = View.GONE
    }

    fun View.show(){
        visibility = View.VISIBLE
    }

    fun Activity.openActivity(clazz: Class<*>,isFinished:Boolean = false){
        if(isFinished) {
            startActivity(Intent(this, clazz))
            this.finish()
        }else{
            startActivity(Intent(this, clazz))
        }
    }

    fun TextView.changeColor(changesPrice: Double, context: Context) {
        if (changesPrice < 0) {
            this.setTextColor(ContextCompat.getColor(context, R.color.red))
        } else if (changesPrice > 0) {
            this.setTextColor(ContextCompat.getColor(context, R.color.green))
        }
    }

}