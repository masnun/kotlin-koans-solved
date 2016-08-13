package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val thisDays: Int = (((year * 12) + month) * 30) + dayOfMonth
        val otherDays: Int = (((other.year * 12) + other.month) * 30) + other.dayOfMonth

        return thisDays - otherDays

    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator()
    }

}

// Too lazy to implement this now

class DateIterator: Iterator<MyDate> {
    override fun next(): MyDate {
        return MyDate(1970, 1, 1)
    }

    override fun hasNext(): Boolean {
        return false
    }



}