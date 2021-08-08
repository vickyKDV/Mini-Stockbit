package com.vickykdv.mystockbit.utils

import com.vickykdv.mystockbit.model.DataItem
import java.text.DecimalFormat

object UtilsHelper {

    fun formatPrice(value: Double): String {
        return DecimalFormat("###,###").format(value)
    }

    fun formatChange(value: Double): String {
        return DecimalFormat("##.##").format(value)
    }

    fun formatPercentage(value: Double): String {
        return DecimalFormat("##.##").format(value)
    }

    fun formatCurrencyChanges(model: DataItem) : String {
        model.rAW.let{ raw ->
            raw.rawIDR.let {
                val changePrice = formatChange(it.cHANGEHOUR)
                val changePricePercentage = formatPercentage(it.cHANGEPCTHOUR)
                return if (it.cHANGEPCTHOUR > 0) {
                    "+$changePrice (+${changePricePercentage}%)"
                } else {
                    "$changePrice (${changePricePercentage}%)"
                }
            }
        }
        return ""
    }
}