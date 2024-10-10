package com.ibtechsolutions.isoflagger.xml.core

import android.view.View
import android.widget.ImageView

interface FlaggerLoader {

    fun loadInto(view: ImageView): FlaggerLoader

    fun load()

}