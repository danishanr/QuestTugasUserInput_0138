package com.example.questtugasuserinput.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.R

@Composable
fun FormBiodata(){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val namaDepan by remember { mutableStateOf("") }
    val namaBelakang by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }
    val tglLahir by remember { mutableStateOf("") }
    val experience by remember { mutableStateOf("") }
    val skills by remember { mutableStateOf("") }

    var showDatePicker by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    val experienceOptions = stringArrayResource(R.array.experience_options)
    val skillOptions = stringArrayResource(R.array.skill_options)
    val snackbarDurationMs = integerResource(R.integer.snackbar_duration_ms)
    val fieldShape = RoundedCornerShape(dimensionResource(R.dimen.field_corner))
    val isValid = namaDepan.isNotBlank() && namaBelakang.isNotBlank() &&
            email.isNotBlank() && tglLahir.isNotBlank() &&
            experience.isNotBlank() && skills.isNotEmpty()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = colorResource(R.color.header_dark)
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

}
