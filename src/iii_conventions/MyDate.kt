package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val thisDays: Int = (((year * 12) + month) * 30) + dayOfMonth
        val otherDays: Int = (((other.year * 12) + other.month) * 30) + other.dayOfMonth

        return thisDays - otherDays

    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
