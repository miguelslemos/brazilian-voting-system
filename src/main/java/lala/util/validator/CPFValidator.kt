package lala.util.validator

/**
 * Created by miguellemos on 30/10/17.
 */
class CPFValidator {

    companion object {
        private val weights = intArrayOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
        private fun calculateDigit(str: String, weights: IntArray): Int {
            var sum = 0
            var index = str.length - 1
            var digit: Int
            while (index >= 0) {
                digit = Integer.parseInt(str.substring(index, index + 1))
                sum += digit * weights[weights.size - str.length + index]
                index--
            }
            sum = 11 - sum % 11
            return if (sum > 9) 0 else sum
        }

        fun isValidCPF(CPF: String?): Boolean {
            if (CPF != null) {
                var cpfNormalized: String = "";
                cpfNormalized = CPF.replace(".", "").replace("-", "")
                if (cpfNormalized.length == 11) {
                    val firstDigit = calculateDigit(cpfNormalized.substring(0, 9), weights)
                    val secondDigit = calculateDigit(cpfNormalized.substring(0, 9) + firstDigit, weights)
                    return cpfNormalized == cpfNormalized.substring(0, 9) + firstDigit.toString() + secondDigit.toString()
                }
            }
            return false
        }

    }
}