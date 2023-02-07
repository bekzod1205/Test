package uz.itschool.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import uz.itschool.test.model.Test

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var index = 0
    var test = arrayListOf<Test>()
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test.add(Test("6+6", "3", "12", "43", "4", "12"))
        test.add(Test("6+34", "3", "12", "43", "40", "40"))
        test.add(Test("89-9", "80", "12", "43", "4", "80"))
        test.add(Test("6+6+3", "15", "12", "43", "4", "15"))
        create_test(index)
        create_question(test.size)
        next.setOnClickListener {
            index++
            if (test.size > index) {
                create_test(index)
            } else {
                index = -1
            }
        }
    }

    fun create_test(index: Int) {
        var test: Test = test[index]
        savol_1.text = test.question
        sj1.text = test.ans1
        sj2.text = test.ans2
        sj3.text = test.ans3
        sj4.text = test.ans4

    }

    fun create_question(number: Int) {
        for (i in 1..number) {
            var button = Button(this)
            button.id = i
            button.tag = i.toString()
            button.text = "$i"
            button.setOnClickListener(this)
            question_num.addView(button)
        }
    }

    fun check_answer(answerId: Int, answer: String) {
        if (test[answerId].correct_ans == answer) {
            count++
        }
    }

    override fun onClick(v: View?) {
        var button: Button = findViewById(v!!.id)
        var buttonTag = button.tag.toString().toInt()
        create_test(buttonTag - 1)
    }

}