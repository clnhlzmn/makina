package xyz.colinholzman.makina

class TestStates {
    companion object {
        //               s1            s2      s3
        //             /   \           |      /  \
        //           /      \         s21   s2   s12
        //         s11      s12
        //        /  \      /  \
        //     s111 s112 s121 s122

        val s111 = State("s111", parentId = listOf("s11"))
        val s112 = State("s112", parentId = listOf("s11"))
        val s11 = State("s11", parentId = listOf("s1"))

        val s121 = State("s121", parentId = listOf("s12"))
        val s122 = State("s122", parentId = listOf("s12"))
        val s12 = State("s12", parentId = listOf("s1"), initial = true)

        val s1 = State("s1")

        val s21 = State("s21", parentId = listOf("s2"))
        val s2 = State("s2", initial = true)

        val s3 = State("s3")

        val s3_s2 = State("s2", parentId = listOf("s3"))
        val s3_s12 = State("s12", parentId = listOf("s3"))

        val machine = Machine("test", listOf(s1, s2, s11, s12, s21, s111, s112, s121, s122, s3, s3_s2, s3_s12))
    }
}