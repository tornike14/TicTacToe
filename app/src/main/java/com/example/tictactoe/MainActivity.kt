package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button

    private lateinit var resetButton: ImageButton

    private lateinit var resultView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sherlok()

        resetButton.setOnClickListener {
            resetGame()
        }

    }


    private fun sherlok() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetButton)

        resultView = findViewById(R.id.resultView)

        //შემდეგზე შექმენი ლისტი ბათონებისთვის, for-loop-საც გმაოიყენებ!!!

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNum = 0

            when(clickedView.id) {

                R.id.button1 -> buttonNum = 1
                R.id.button2 -> buttonNum = 2
                R.id.button3 -> buttonNum = 3
                R.id.button4 -> buttonNum = 4
                R.id.button5 -> buttonNum = 5
                R.id.button6 -> buttonNum = 6
                R.id.button7 -> buttonNum = 7
                R.id.button8 -> buttonNum = 8
                R.id.button9 -> buttonNum = 9

            }

            if (buttonNum != 0) {
                playGame(clickedView, buttonNum)
            }

        }

    }

    private var activePlayer = 1
    private var firstPLayer = ArrayList<Int>()
    private var secondPLayer = ArrayList<Int>()


    private fun playGame(clickedView: Button, buttonNum: Int) {
        if (activePlayer == 1) {
            clickedView.text = "x"
            clickedView.setBackgroundColor(Color.CYAN)
            firstPLayer.add(buttonNum)
            activePlayer = 2
        } else {
            clickedView.text = "o"
            clickedView.setBackgroundColor(Color.MAGENTA)
            secondPLayer.add(buttonNum)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        if (firstPLayer.contains(1) && firstPLayer.contains(2) && firstPLayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(1) && secondPLayer.contains(2) && secondPLayer.contains(3)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(4) && firstPLayer.contains(5) && firstPLayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(4) && secondPLayer.contains(5) && secondPLayer.contains(6)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(7) && firstPLayer.contains(8) && firstPLayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(7) && secondPLayer.contains(8) && secondPLayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(1) && firstPLayer.contains(4) && firstPLayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(1) && secondPLayer.contains(4) && secondPLayer.contains(7)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(2) && firstPLayer.contains(5) && firstPLayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(2) && secondPLayer.contains(5) && secondPLayer.contains(8)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(3) && firstPLayer.contains(6) && firstPLayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(3) && secondPLayer.contains(6) && secondPLayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(1) && firstPLayer.contains(5) && firstPLayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(1) && secondPLayer.contains(5) && secondPLayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPLayer.contains(3) && firstPLayer.contains(5) && firstPLayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPLayer.contains(3) && secondPLayer.contains(5) && secondPLayer.contains(7)) {
            winnerPlayer = 2
        }


        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                resultView.text = "X win!"
            } else {
                resultView.text = "O win!"
            }
            disableAllButtons()
        } else {

            var count = firstPLayer.count() + secondPLayer.count()

            if (count >= 9) {
                resultView.text = "Tie!"

                disableAllButtons()
            }
        }

    }

    private fun disableAllButtons() {

        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }

    private fun resetGame() {

        button1.setBackgroundResource(R.color.colorPrimary)
        button2.setBackgroundResource(R.color.colorPrimary)
        button3.setBackgroundResource(R.color.colorPrimary)
        button4.setBackgroundResource(R.color.colorPrimary)
        button5.setBackgroundResource(R.color.colorPrimary)
        button6.setBackgroundResource(R.color.colorPrimary)
        button7.setBackgroundResource(R.color.colorPrimary)
        button8.setBackgroundResource(R.color.colorPrimary)
        button9.setBackgroundResource(R.color.colorPrimary)

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        resultView.text = ""

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        activePlayer = 1

        firstPLayer.clear()
        secondPLayer.clear()

    }

}