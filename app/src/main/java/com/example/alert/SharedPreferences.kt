package com.example.alert

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alert.databinding.ActivitySharedPreferencesBinding

class SharedPreferences : AppCompatActivity() {
    lateinit var binding:ActivitySharedPreferencesBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        loadData()
        binding.save.setOnClickListener{
            if(binding.etName.text.toString().isEmpty()){
                Toast.makeText(this,"Enter name",Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("data",binding.etName.text.toString())
                editor.apply()
                Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show()
            }
        }
        binding.delete.setOnClickListener(){
            editor.remove("data")
            editor.apply()
            Toast.makeText(this,"deleted",Toast.LENGTH_SHORT).show()
            loadData()
        }
        binding.mode.setOnClickListener(){
            AlertDialog.Builder(this).apply {
                setTitle("ChangeMode")
                setPositiveButton("Dark"){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("dark",true)
                    editor.commit()
                    editor.apply()
                }
                setNegativeButton("No"){_,_,->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("dark",false)
                    editor.commit()
                    editor.apply()
            }

        }.show()
    }

    }
    fun loadData(){
        val name=sharedPreferences.getString("data","")
        binding.etName.setText(name)
        if(sharedPreferences.getBoolean("dark",false)){

        }
    }
}
