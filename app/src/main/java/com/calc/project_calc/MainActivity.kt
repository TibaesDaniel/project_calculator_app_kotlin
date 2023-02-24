package com.calc.project_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calc.project_calc.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.point.setOnClickListener{current(string = ".", keyss = true)}
        binding.numberZero.setOnClickListener{current(string = "0", keyss = true)}
        binding.numberOne.setOnClickListener{current(string = "1", keyss = true)}
        binding.numberTwo.setOnClickListener{current(string = "2", keyss = true)}
        binding.numberThree.setOnClickListener{current(string = "3", keyss = true)}
        binding.numberFour.setOnClickListener{current(string = "4", keyss = true)}
        binding.numberFive.setOnClickListener{current(string = "5", keyss = true)}
        binding.numberSix.setOnClickListener{current(string = "6", keyss = true)}
        binding.numberSeven.setOnClickListener{current(string = "7", keyss = true)}
        binding.numberEight.setOnClickListener{current(string = "8", keyss = true)}
        binding.numberNine.setOnClickListener{current(string = "9", keyss = true)}
        binding.addition.setOnClickListener { current(string = "+", keyss = false) }


        binding.addition.setOnClickListener{current(string = "+", keyss = false)}
        binding.multiplication.setOnClickListener{current(string = "*", keyss = false)}
        binding.division.setOnClickListener{current(string = "/", keyss = false)}
        binding.subtraction.setOnClickListener{current(string = "-", keyss = false)}
        binding.porcent.setOnClickListener{current(string = "%", keyss = false)}

        binding.clear.setOnClickListener {
            binding.currentView.text = ""
            binding.previusView.text = ""
        }

        binding.delete.setOnClickListener {
            val string = binding.currentView.text.toString()
            if (string.isNotBlank()){
                binding.currentView.text = string.substring(0, string.length-1)
            }
        }

        binding.equal.setOnClickListener {

            try {
                if(binding.currentView.text !== ""){

                    binding.previusView.append(binding.currentView.text)

                }
                    val express = ExpressionBuilder(binding.previusView.text.toString()).build()
                    val result = express.evaluate()
                    val longResult = result.toLong()

                    if(result == longResult.toDouble()){
                        binding.currentView.text = longResult.toString()
                    }else{
                        binding.currentView.text = result.toString()
                    }

                    binding.previusView.text = ""


            }catch (e: Exception){

            }
        }
    }

    fun current(string: String, keyss:Boolean){

        if(keyss){
            binding.currentView.append(string)
        }else {
            binding.previusView.append(binding.currentView.text)
            binding.previusView.append(string)
            binding.currentView.text = ""
        }

    }
}