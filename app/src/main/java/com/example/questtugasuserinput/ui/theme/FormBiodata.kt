package com.example.questtugasuserinput.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

            Image(
                painter = painterResource(R.drawable.bg_header),
                contentDescription = stringResource(R.string.cd_header_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
            )

            Row(
                modifier = Modifier.padding(dimensionResource(R.dimen.dots_padding)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_small))
            ) {
                repeat(integerResource(R.integer.dot_count)) { index ->
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.dot_size))
                            .background(
                                color = colorResource(
                                    if (index == 0) R.color.dot_active else R.color.dot_inactive
                                ),
                                shape = CircleShape
                            )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(R.dimen.sheet_offset_top))
                    .shadow(
                        dimensionResource(R.dimen.sheet_elevation),
                        RoundedCornerShape(
                            topStart = dimensionResource(R.dimen.sheet_corner),
                            topEnd = dimensionResource(R.dimen.sheet_corner)
                        )
                    )
                    .clip(
                        RoundedCornerShape(
                            topStart = dimensionResource(R.dimen.sheet_corner),
                            topEnd = dimensionResource(R.dimen.sheet_corner)
                        )
                    )
                    .background(colorResource(R.color.sheet_background))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.sheet_padding)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.title_form),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.purple_title)
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_small)))
                    Text(
                        text = stringResource(R.string.subtitle_form),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(R.color.gray_subtitle),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_large)))

                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_small))) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            singleLine = true,
                            shape = fieldShape,
                            label = { Text(stringResource(R.string.hint_nama_depan)) },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            singleLine = true,
                            shape = fieldShape,
                            label = { Text(stringResource(R.string.hint_nama_belakang)) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        singleLine = true,
                        shape = fieldShape,
                        label = { Text(stringResource(R.string.hint_email)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))

                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_small))) {
                        OutlinedTextField(
                            value = tglLahir,
                            onValueChange = {},
                            readOnly = true,
                            singleLine = true,
                            shape = fieldShape,
                            label = { Text(stringResource(R.string.hint_tgl_lahir)) },
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = stringResource(R.string.cd_pilih_tanggal)
                                    )
                                }
                            },
                            modifier = Modifier.weight(1f)
                        )
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = it },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                singleLine = true,
                                shape = fieldShape,
                                label = { Text(stringResource(R.string.hint_experience)) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                                modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                experienceOptions.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            experience = option
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))
                    Text(
                        text = stringResource(R.string.label_skill),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        skillOptions.forEach { skill ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = skills.contains(skill),
                                    onCheckedChange = { checked ->
                                        if (checked) skills.add(skill) else skills.remove(skill)
                                    }
                                )
                                Text(skill, style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_large)))
                }
            }
        }
    }
}
