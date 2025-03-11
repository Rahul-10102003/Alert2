package com.example.alert.firestore

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alert.R
import com.example.alert.databinding.ActivityFireStoreBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FireStoreActivity : AppCompatActivity(),  FireAdapter.click {
    lateinit var binding: ActivityFireStoreBinding
    var list=ArrayList<Fireitem>()
    lateinit var fireAdapter: FireAdapter
    var db=Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fire_store)
        fireAdapter=FireAdapter(list,this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        db.collection("Students").addSnapshotListener{snapshots,e->
//            if(e)
//        }

    }

    override fun update(position: Int) {
        TODO("Not yet implemented")
    }

    override fun add(position: Int) {
        TODO("Not yet implemented")
    }
}