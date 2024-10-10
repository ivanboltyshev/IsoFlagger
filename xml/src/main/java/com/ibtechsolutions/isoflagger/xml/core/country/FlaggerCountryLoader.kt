package com.ibtechsolutions.isoflagger.xml.core.country

import android.widget.ImageView
import com.ibtechsolutions.isoflagger.xml.Flagger
import com.ibtechsolutions.isoflagger.xml.core.FlaggerLoader
import com.ibtechsolutions.isoflagger.xml.core.iso.CountryIso
import kotlin.properties.Delegates

class FlaggerCountryLoader : FlaggerLoader {

    private var code: String = ""
        set(value) {
            require(value.isNotEmpty()) { "Country code length must be > 0" }
            field = value
        }

    private var targetView: ImageView by Delegates.notNull()

    private var iso: CountryIso = CountryIso.ISO_3166_1

    fun code(code: String) = apply {
        this.code = code
    }

    override fun loadInto(view: ImageView): FlaggerLoader = this.apply {
        this.targetView = view
    }

    override fun load() {
        val countryCode = code.lowercase()
        val flag = CountryCoordinator.getMapByIso(iso)[countryCode] ?: Flagger.unknownFlag
        targetView.setImageResource(flag)
    }

}