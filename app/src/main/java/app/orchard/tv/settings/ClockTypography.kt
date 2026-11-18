package app.orchard.tv.settings

import android.os.Build
import app.orchard.tv.R

enum class ClockWeight(val key: String, val label: Int, val weight: Int?) {
    Regular("regular", R.string.st_clock_weight_regular, 400),
    Default("default", R.string.st_clock_typography_default, null),
    ExtraBold("extra_bold", R.string.st_clock_weight_extra_bold, 800);

    companion object {
        // On older TVs the default is already the system's bold face.
        val choices: List<ClockWeight>
            get() = if (Build.VERSION.SDK_INT >= 26) entries else listOf(Regular, Default)

        fun of(key: String?) = choices.firstOrNull { it.key == key } ?: Default
    }
}

enum class ClockSpacing(val key: String, val label: Int, val offsetEm: Float) {
    Compact("compact", R.string.st_clock_spacing_compact, -0.03f),
    Default("default", R.string.st_clock_typography_default, 0f),
    Wide("wide", R.string.st_clock_spacing_wide, 0.04f);

    companion object {
        fun of(key: String?) = entries.firstOrNull { it.key == key } ?: Default
    }
}
