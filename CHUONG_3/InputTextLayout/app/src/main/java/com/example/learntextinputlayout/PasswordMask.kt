package com.example.learntextinputlayout

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.google.android.material.textfield.TextInputLayout

class PasswordMask private constructor(): PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    class PasswordCharSequence(private val source: CharSequence): CharSequence {
        override val length: Int
            get() = source.length

        override fun get(index: Int): Char {
            return 'x'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return source.subSequence(startIndex, endIndex)
        }
    }

    companion object{
        private val instance = PasswordMask()
        fun getInstance(): PasswordMask{
            return instance
        }
    }
}

fun TextInputLayout.addEndIconOnClickListener(){
    var isVisible = false
    this.setEndIconOnClickListener {
        if (isVisible) {
            isVisible = false
            editText?.transformationMethod = PasswordMask.getInstance()
        } else {
            isVisible = true
            editText?.transformationMethod = HideReturnsTransformationMethod()
        }
        val length = editText?.text?.length ?: 0
        editText?.setSelection(length)
    }
}