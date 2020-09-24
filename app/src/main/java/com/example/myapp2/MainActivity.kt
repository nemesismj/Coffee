package com.example.myapp2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private var receipt: Coffe? = null
    private var quantityView: TextView? = null
    private var whippingCreamStatement: CheckBox? = null
    private var chocolateStatement: CheckBox? = null
    private lateinit var minusButton: Button
    private lateinit var plusButton: Button
    private var lastTextView: TextView? = null
    private var thanksTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receipt = Coffe()
        whippingCreamStatement = findViewById<CheckBox>(R.id.checkBox)
        chocolateStatement = findViewById<CheckBox>(R.id.checkBox2)
        quantityView = findViewById<TextView>(R.id.textView2)
        lastTextView = findViewById<TextView>(R.id.textView3)
        thanksTextView = findViewById<TextView>(R.id.textView4)
        minusButton = findViewById<Button>(R.id.button2)
        plusButton = findViewById<Button>(R.id.button3)
    }
    fun onCreamCheckboxClicked(view: View): String? {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox -> {
                    if (checked) {
                        receipt?.setCream(checked)
                    }
                    else receipt?.setChocolate(!checked)
                }
            }
        }
        return receipt?.getWhippingCream()
    }

        fun onChocolateCheckboxClicked(view: View): String? {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.checkBox2 -> {
                        if (checked) {
                            receipt?.setChocolate(checked)
                        }
                        else receipt?.setChocolate(!checked)
                    }
                }
            }
            return receipt?.getChocolate()
        }
    @SuppressLint("SetTextI18n")
    fun increaseQuantity(view: View?) {
        plusButton.setOnClickListener{
            receipt?.increment()
            println(receipt?.getQuantity())
            quantityView?.text = "Quantity: " + receipt?.getQuantity()
        }

    }

    @SuppressLint("SetTextI18n")
    fun decreaseQuantity(view: View?) {
        minusButton.setOnClickListener{
            receipt?.decrement()
            println(receipt?.getQuantity())
            quantityView?.text = "Quantity: " + receipt?.getQuantity()
        }

    }
    fun completeOrder(view: View?) {
        val cost: String = "Total cost: $" + receipt?.computeOrder()
        val message =
            """
            ${whippingCreamStatement!!.text} ${onCreamCheckboxClicked(whippingCreamStatement!!)}
            ${chocolateStatement!!.text} ${onChocolateCheckboxClicked(chocolateStatement!!)}
            ${quantityView?.text} 
            $cost
            """.trimIndent()
        lastTextView?.text = message
        thanksTextView?.text = "THANKS BOYZ"
    }
}
