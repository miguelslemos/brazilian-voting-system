package lala.data.models

import java.util.*

/**
 * Created by miguellemos on 03/10/17.
 */
class Election private constructor(val cadidates: ArrayList<Candidate>, var durationTime: Int, var votes: Votes, var isOpen: Boolean = true) {
    private constructor(builder: Builder) : this(builder.cadidates, builder.durationTime, Votes())

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        lateinit var cadidates: ArrayList<Candidate>
        var durationTime: Int = 0

        fun cadidates(init: Builder.() ->  ArrayList<Candidate>) = apply { cadidates = init() }

        fun durationTime(init: Builder.() -> Int) = apply { durationTime = init() }

        fun build() = Election(this)
    }
}