package com.miu.quizeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.miu.quizeapp.databinding.ActivityMainBinding
import java.util.Date
import kotlin.math.roundToInt
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSubmit.setOnClickListener {
            var date:Date = Date()

            val dateFormat = SimpleDateFormat("EEEE, MM-dd-yyyy HH:mm:ss")
            val formattedDate = dateFormat.format(date)

            var score: Double = 0.0


            if(binding.radioButton3.isChecked){
                score +=50.00
            }
            if(binding.checkBox2.isChecked){
                score += 25.00
            }
            if(binding.checkBox3.isChecked){
                score += 25.00
            }
            var scoreRound:Int = score.roundToInt()

        //    Toast.makeText(this, "$date $scoreRound $scoreRound", Toast.LENGTH_LONG).show()

            if(scoreRound > 0){
                var builder = AlertDialog.Builder(this)
                builder.setTitle("Congratulations!")
                builder.setMessage("You submitted on $formattedDate \r\n You acchived $scoreRound%")
                builder.setIcon(R.drawable.ic_launcher_foreground)

                builder.setPositiveButton("OK"){
                    dialogueInterface, whichId -> dialogueInterface.dismiss()
                }
                builder.setNegativeButton("Cancel"){
                    dialogueInterface, whichId ->dialogueInterface.dismiss()
                }
                var dialogue: AlertDialog = builder.create()
                dialogue.show()
            }

        }
        binding.buttonReset.setOnClickListener {
            binding.rgQuestOne.clearCheck()

            for (i in 0 until binding.rgQuestTwo.childCount){
                val obj = binding.rgQuestTwo.getChildAt(i)
                if(obj is CheckBox){
                    obj.isChecked = false
                }
            }
            Toast.makeText(this, "Reset successfully", Toast.LENGTH_LONG).show()
        }
    }
}