package com.example.three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import com.example.three.R
import com.example.three.databinding.ActivityMainBinding
import android.view.View
import androidx.activity.viewModels
import com.example.hw4.CounterViewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Got a CounterViewModel: $counterViewModel")

        displayForTeamA(counterViewModel.scoreTeamA)
        displayForTeamB(counterViewModel.scoreTeamB)
    }

    fun addOneForTeamA(v: View?) {
        counterViewModel.scoreTeamA++
        displayForTeamA(counterViewModel.scoreTeamA)
    }

    fun addTwoForTeamA(v: View?) {
        counterViewModel.scoreTeamA += 2
        displayForTeamA(counterViewModel.scoreTeamA)
    }

    fun addThreeForTeamA(v: View?) {
        counterViewModel.scoreTeamA += 3
        displayForTeamA(counterViewModel.scoreTeamA)
    }


    fun addOneForTeamB(v: View?) {
        counterViewModel.scoreTeamB++
        displayForTeamB(counterViewModel.scoreTeamB)
    }

    fun addTwoForTeamB(v: View?) {
        counterViewModel.scoreTeamB += 2
        displayForTeamB(counterViewModel.scoreTeamB)
    }

    fun addThreeForTeamB(v: View?) {
        //use scoreTeamB variable from counterViewModel
        counterViewModel.scoreTeamB += 3
        displayForTeamB(counterViewModel.scoreTeamB)
    }

    fun resetScore(v: View?) {
        counterViewModel.scoreTeamA = 0
        counterViewModel.scoreTeamB = 0
        displayForTeamA(counterViewModel.scoreTeamA)
        displayForTeamB(counterViewModel.scoreTeamB)
    }

    fun displayForTeamA(score: Int) {
        val scoreView = binding.teamAScore
        scoreView.text = score.toString()
    }

    fun displayForTeamB(score: Int) {
        val scoreView = binding.teamBScore
        scoreView.text = score.toString()
    }
}