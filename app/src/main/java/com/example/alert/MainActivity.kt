package com.example.alert

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alert.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var list= arrayOf("dbsv","shcg","wchdg","shc")
    var checklist= booleanArrayOf(false,false,false,false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn1.setOnClickListener() {
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.custom_layout)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            dialog.findViewById<Button>(R.id.button1).setOnClickListener(){
                dialog.dismiss()
            }
        }
        binding.btn2.setOnClickListener() {
            Snackbar.make(it, "this is snackbar", Snackbar.LENGTH_LONG).setAction("undo", {
                Toast.makeText(this, "backed", Toast.LENGTH_SHORT).show()
            }).show()
        }
        binding.btn3.setOnClickListener() {
            AlertDialog.Builder(this).apply {
                setTitle("select")
                setPositiveButton("yes") { _, _ -> }
                setNegativeButton("no") { _, _ -> }
                setNeutralButton("cancel") { _, _ -> }
                setCancelable(true)
                show()
            }
        }
        binding.btn4.setOnClickListener() {
            AlertDialog.Builder(this).apply {
                setTitle("select")
                setItems(list) { _, which ->
                    Toast.makeText(this@MainActivity, list[which].toString(), Toast.LENGTH_SHORT).show() }
                    setPositiveButton("yes") { _, _ -> }
                    setNegativeButton("No") { _, _ -> }
                    setNeutralButton("cancel") { _, _ -> }
                    setCancelable(true)
                    show()
                }
            }
        binding.btn5.setOnClickListener(){
            AlertDialog.Builder(this).apply{
                setTitle("select")
                setMultiChoiceItems(list,checklist){_,which,isChecked,->
                    checklist[which] = isChecked
                    Toast.makeText(this@MainActivity, list[which].toString(), Toast.LENGTH_SHORT).show() }
                setPositiveButton("yes"){_,_,->}
                setNegativeButton("No"){_,_,->}
                setNeutralButton("Cancel"){_,_,->}
                setCancelable(false)
                show()
            }
        }


        }
    }

