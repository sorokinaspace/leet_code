object Test {
    fun assert(a: Boolean, b: Boolean, condition: String? = null) {
        if (a != b) {
            println("❌ FAILED $a != $b ${if (condition == null) "" else "for $condition"}")
        } else {
            println("✅ PASSED $a == $b ${if (condition == null) "" else "for $condition"}")
        }
    }

    fun assert(a: Boolean, condition: String? = null) {
        if (!a) {
            println("❌ FAILED $a != true ${if (condition == null) "" else "for $condition"}")
        } else {
            println("✅ PASSED $a == true ${if (condition == null) "" else "for $condition"}")
        }
    }

    fun assert(a: Int?, b: Int?, condition: String? = null) {
        if (a != b) {
            println("❌ FAILED $a != $b ${if (condition == null) "" else "for $condition"}")
        } else {
            println("✅ PASSED $a == $b ${if (condition == null) "" else "for $condition"}")
        }
    }
}