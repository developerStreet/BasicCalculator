package com.dev.gauravbhagat.calculator

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textview.MaterialTextView
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    private lateinit var menuItem: ImageView
    private lateinit var buttonDiv: ImageView
    private lateinit var buttonMul: ImageView
    private lateinit var buttonMin: ImageView
    private lateinit var buttonAdd: ImageView
    private lateinit var buttonDot: ImageView
    private lateinit var buttonClr: ImageView
    private lateinit var buttonEql: ImageView
    private lateinit var buttonBkt: ImageView

    private lateinit var numpadTwoButton: ImageView
    private lateinit var numpadOneButton: ImageView
    private lateinit var numpadThreeButton: ImageView
    private lateinit var numpadFourButton: ImageView
    private lateinit var numpadFiveButton: ImageView
    private lateinit var numpadSixButton: ImageView
    private lateinit var numpadSevenButton: ImageView
    private lateinit var numpadEightButton: ImageView
    private lateinit var numpadNineButton: ImageView
    private lateinit var numpadZeroButton: ImageView

    private lateinit var equationText: MaterialTextView
    private lateinit var resultText: MaterialTextView

    private lateinit var mediaPlayer: MediaPlayer

    private var workings: String = ""
    private var formula: String = ""
    private var tempFormula: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        mediaPlayer = MediaPlayer.create(this, R.raw.tap_sound)
        /*
        Declaring Pop Up Menu
         */
        menuItem = findViewById(R.id.popUpMenu)
        menuItem.setOnClickListener {
            showPopupMenu()
        }

        initTextViews()
        initializeAllButtons()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showPopupMenu() {
        val popupMenu = PopupMenu(this, menuItem)
        popupMenu.menuInflater.inflate(R.menu.pop_up_menu, popupMenu.menu)
        menuItem.setImageDrawable(getDrawable(R.drawable.ic_baseline_close_24))
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.show()

        popupMenu.setOnDismissListener {
            menuItem.setImageDrawable(getDrawable(R.drawable.ic_baseline_menu_24))
        }

    }

    private fun initializeAllButtons() {
        buttonDiv = findViewById(R.id.sym_divide)
        buttonMul = findViewById(R.id.sym_multiply)
        buttonMin = findViewById(R.id.sym_minus)
        buttonAdd = findViewById(R.id.sym_plus)
        buttonDot = findViewById(R.id.sym_dot)
        buttonClr = findViewById(R.id.sym_clear)
        buttonEql = findViewById(R.id.sym_equals)
        buttonBkt = findViewById(R.id.sym_bracket)

        buttonDiv.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        buttonMin.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonClr.setOnClickListener(this)
        buttonEql.setOnClickListener(this)
        buttonBkt.setOnClickListener(this)

        numpadOneButton = findViewById(R.id.numpad_1)
        numpadTwoButton = findViewById(R.id.numpad_2)
        numpadThreeButton = findViewById(R.id.numpad_3)
        numpadFourButton = findViewById(R.id.numpad_4)
        numpadFiveButton = findViewById(R.id.numpad_5)
        numpadSixButton = findViewById(R.id.numpad_6)
        numpadSevenButton = findViewById(R.id.numpad_7)
        numpadEightButton = findViewById(R.id.numpad_8)
        numpadNineButton = findViewById(R.id.numpad_9)
        numpadZeroButton = findViewById(R.id.numpad_0)

        numpadOneButton.setOnClickListener(this)
        numpadTwoButton.setOnClickListener(this)
        numpadThreeButton.setOnClickListener(this)
        numpadFourButton.setOnClickListener(this)
        numpadFiveButton.setOnClickListener(this)
        numpadSixButton.setOnClickListener(this)
        numpadSevenButton.setOnClickListener(this)
        numpadEightButton.setOnClickListener(this)
        numpadNineButton.setOnClickListener(this)
        numpadZeroButton.setOnClickListener(this)
    }

    private fun initTextViews() {
        equationText = findViewById(R.id.equation_box)
        resultText = findViewById(R.id.display_result)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.pop_up_sound -> {
                Toast.makeText(applicationContext, "Sound ON", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                false
            }
        }
    }

    private var leftBracket = true

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.numpad_0 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadZeroButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("0")
            }
            R.id.numpad_1 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadOneButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("1")
            }
            R.id.numpad_2 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadTwoButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("2")
            }
            R.id.numpad_3 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadThreeButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("3")
            }
            R.id.numpad_4 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadFourButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("4")
            }
            R.id.numpad_5 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadFiveButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("5")
            }
            R.id.numpad_6 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadSixButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("6")
            }
            R.id.numpad_7 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadSevenButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("7")
            }
            R.id.numpad_8 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadEightButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("8")
            }
            R.id.numpad_9 -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                numpadNineButton.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("9")
            }
            R.id.sym_divide -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonDiv.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("/")
            }
            R.id.sym_multiply -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonMul.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("*")
            }
            R.id.sym_minus -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonMin.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("-")
            }
            R.id.sym_plus -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonAdd.startAnimation(animation)
                mediaPlayer.start()
                setWorkings("+")
            }
            R.id.sym_bracket -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonBkt.startAnimation(animation)
                mediaPlayer.start()
                leftBracket = if (leftBracket) {
                    setWorkings("(")
                    false
                } else {
                    setWorkings(")")
                    true
                }
            }
            R.id.sym_clear -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonClr.startAnimation(animation)
                mediaPlayer.start()
                resultText.text = "0"
                workings = ""
                equationText.text = ""
            }
            R.id.sym_dot -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonDot.startAnimation(animation)
                mediaPlayer.start()
                setWorkings(".")
            }
            R.id.sym_equals -> {
                val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
                buttonEql.startAnimation(animation)
                mediaPlayer.start()

                var result: Double? = null
                val engine = ScriptEngineManager().getEngineByName("rhino")
                checkForEquation()
                try {
                    result = engine.eval(formula) as Double?
                } catch (e: ScriptException) {
                    Toast.makeText(applicationContext, "Invalid Equation", Toast.LENGTH_SHORT).show()
                }
                if (result != null) {
                    resultText.text = result.toString()
                    workings = ""
                    equationText.text = ""
                }
            }
        }
    }

    private fun checkForEquation() {
        formula = workings
        tempFormula = workings
        formula = tempFormula
    }

    @JvmName("setWorkings1")
    private fun setWorkings(givenValue: String) {
        workings += givenValue
        equationText.text = workings
    }
}