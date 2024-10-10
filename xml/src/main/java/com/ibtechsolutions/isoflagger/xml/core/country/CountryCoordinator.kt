package com.ibtechsolutions.isoflagger.xml.core.country

import com.ibtechsolutions.isoflagger.xml.core.iso.CountryIso

internal object CountryCoordinator {

    fun getMapByIso(iso: CountryIso): Map<String, Int> {
        return when (iso) {
            CountryIso.ISO_3166_1 -> countryIso3166_1
        }
    }

}