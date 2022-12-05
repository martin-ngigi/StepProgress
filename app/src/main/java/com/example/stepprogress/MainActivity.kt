package com.example.stepprogress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepprogress.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * pdate steps count and their titles
         */
        val stepsCount = 4
        binding.vStepProgress.setStepsCount(stepsCount)
        binding.vStepProgress.setStepTitles(List(stepsCount) {"Step ${it + 1}"})

        /**
         * update state of a progress
         */
        binding.nextBtn.setOnClickListener {
            //pass "true" to nextStep method to mark current selected step as finished
            val isFinished = binding.vStepProgress.nextStep(true)
            if (isFinished){
                Snackbar.make(it, "Step  Done", Snackbar.LENGTH_SHORT).show()
            }
        }

        //Mark current selected step as done
        binding.doneBtn.setOnClickListener {
            binding.vStepProgress.markCurrentAsDone()
        }

        //Mark current selected step as undone
        binding.undoneBtn.setOnClickListener {
            binding.vStepProgress.markCurrentAsUndone()
        }

        //Checks if step in a specific position is finished
        //vStepProgress.isStepDone(0)

        //Checks if all steps of a progress are finished
        //vStepProgress.isProgressFinished()

    }

    /**
     * val stepsCount = 4
    //Set number of steps for progress
    vStepProgress.setStepsCount(stepsCount)
    //Set title for each step
    vStepProgress.setStepTitles(List(stepsCount) { "Step ${it + 1}" })
    //!Two methods above should be applied together to ensure progress state consistence

    //Go to next step. Receives boolean value which decides if current step should be marked as done
    vStepProgress.nextStep(true)
    ...
    //Mark current selected step as done
    vStepProgress.markCurrentAsDone()
    ...
    //Mark current selected step as undone
    vStepProgress.markCurrentAsUndone()
    ...
    //Checks if step in a specific position is finished
    vStepProgress.isStepDone(0)
    ...
    //Checks if all steps of a progress are finished
    vStepProgress.isProgressFinished()
    ...
     */
}