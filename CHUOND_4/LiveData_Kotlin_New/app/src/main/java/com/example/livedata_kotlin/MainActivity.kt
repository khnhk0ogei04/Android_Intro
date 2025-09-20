package com.example.livedata_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: StaffViewModel
    private lateinit var btnAddNew: Button
    private lateinit var edtStaffId: TextInputEditText
    private lateinit var edtFullName: TextInputEditText
    private lateinit var edtBirthDate: TextInputEditText
    private lateinit var edtSalary: TextInputEditText
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()

        viewModel = ViewModelProvider(this)[StaffViewModel::class.java]
        setupObserver()
        setupListener()
    }

    private fun setupObserver() {
        viewModel.staff.observe(this) {
            if (it.isNullOrEmpty()) {
                txtResult.text = getString(R.string.text_no_result)
            } else {
                val stringBuilder = StringBuilder()
                for (staff in it){
                    stringBuilder.append(staff).append("\n")
                }
                txtResult.text = stringBuilder.toString()
            }
        }
    }

    private fun setupListener() {
        btnAddNew.setOnClickListener {
            val staffId = edtStaffId.text?.toString().orEmpty()
            val fullName = edtFullName.text?.toString().orEmpty()
            val birthDate = edtBirthDate.text?.toString().orEmpty()
            val salary = edtSalary.text?.toString()?.toLongOrNull() ?: 0L
            viewModel.addStaff(staffId, fullName, birthDate, salary)
        }
    }

    private fun setupViews() {
        btnAddNew = findViewById(R.id.btn_add_new_staff)
        txtResult = findViewById(R.id.txt_result)
        edtStaffId = findViewById(R.id.edt_staff_id)
        edtFullName = findViewById(R.id.edt_full_name)
        edtSalary = findViewById(R.id.edt_salary)
        edtBirthDate = findViewById(R.id.edt_birth_date)
    }
}
