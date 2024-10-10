package com.ibtechsolutions.isoflagger.xml

import androidx.annotation.DrawableRes
import com.ibtechsolutions.isoflagger.xml.core.country.FlaggerCountryLoader
import com.ibtechsolutions.isoflagger.xml.core.language.FlaggerLanguageLoader

object Flagger {

    @DrawableRes
    internal var unknownFlag: Int = 0

    fun setUnknownFlag(@DrawableRes resId: Int) {
        this.unknownFlag = resId
    }

    fun country(): FlaggerCountryLoader = FlaggerCountryLoader()

    fun language(): FlaggerLanguageLoader = FlaggerLanguageLoader()

}