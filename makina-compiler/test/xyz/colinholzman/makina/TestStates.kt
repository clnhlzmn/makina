package xyz.colinholzman.makina

class TestStates {
    companion object {
        //               s1            s2
        //             /   \           |
        //           /      \         s21
        //         s11      s12
        //        /  \      /  \
        //     s111 s112 s121 s122

        val s111 = State("s111")
        val s112 = State("s112")
        val s11 = State("s11")

        val s121 = State("s121")
        val s122 = State("s122")
        val s12 = State("s12")

        val s1 = State("s1")

        val s21 = State("s21")
        val s2 = State("s2")

        init {
            s111.parent = s11
            s112.parent = s11

            s121.parent = s12
            s122.parent = s12

            s11.parent = s1
            s12.parent = s1

            s21.parent = s2

            s2.subStates.add(s21)
            s1.subStates.addAll(listOf(s11, s12))

            s11.subStates.addAll(listOf(s111, s112))
            s12.subStates.addAll(listOf(s121, s122))
        }
    }
}