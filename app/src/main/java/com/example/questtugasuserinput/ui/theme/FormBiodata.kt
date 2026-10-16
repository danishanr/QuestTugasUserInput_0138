package com.example.questtugasuserinput.ui.theme

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext

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
}
