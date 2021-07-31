package dev.gtcl.travelbank

import android.text.TextPaint
import android.text.style.SuperscriptSpan

class CustomSuperscriptSpan : SuperscriptSpan() {

    override fun updateDrawState(textPaint: TextPaint) {
        textPaint.baselineShift += ((1 * textPaint.ascent()) / 5).toInt()
    }

    override fun updateMeasureState(textPaint: TextPaint) {
        textPaint.baselineShift += ((1 * textPaint.ascent()) / 5).toInt()
    }

}