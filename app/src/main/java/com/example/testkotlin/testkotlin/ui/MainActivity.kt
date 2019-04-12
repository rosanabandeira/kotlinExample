package com.example.testkotlin.testkotlin.ui


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import com.example.testkotlin.R
import com.example.testkotlin.testkotlin.extensions.CpfMask
import com.example.testkotlin.testkotlin.extensions.CpfUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCpf.addTextChangedListener(CpfMask.mask("###.###.###-##", editTextCpf))

        button1.setOnClickListener { view ->


            if (CpfUtil.myValidateCPF(editTextCpf.text.toString())) {
                editTextCpf.text.toString()

            } else {
                editTextCpf.setError("CPF Inválido")
                return@setOnClickListener
            }

            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.dialog_layout, null)
            dialog.setContentView(view)
            dialog.show()

            val intent = Intent(this, LoginEmailActivity::class.java)



            startActivity(intent)


        }


    }
}



