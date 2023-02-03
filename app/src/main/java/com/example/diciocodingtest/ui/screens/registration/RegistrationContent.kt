package com.example.diciocodingtest.ui.screens.registration

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.diciocodingtest.R
import com.example.diciocodingtest.ui.theme.LARGE_PADDING
import com.example.diciocodingtest.ui.theme.MEDIUM_PADDING
import com.example.diciocodingtest.util.Utils


@Composable
fun RegistrationContent(
    name:String = "",
    onNameChange: (String) -> Unit,
    firstFamilyName:String = "",
    onFirstFamilyNameChange: (String) -> Unit,
    secondFamilyName:String = "",
    onSecondFamilyNameChange: (String) -> Unit,
    age:String = "",
    onAgeChange: (String) -> Unit,
    email:String = "",
    onEmailChange: (String) -> Unit,
    dob:String = "",
    onDobChange: (String) -> Unit,
    number:String = "", //** info
    onNumberChange: (String) -> Unit,
    street:String = "",
    onStreetChange: (String) -> Unit,
    neighborhood:String = "",
    onNeighborhoodChange: (String) -> Unit,
    municipality:String = "",
    onMunicipalityChange: (String) -> Unit,
    state:String = "",
    onStateChange: (String) -> Unit,
    zipCode:String = "",
    onZipCodeChange: (String) -> Unit,
    onImageSelected: (Bitmap?) -> Unit,
    onSave: () -> Unit,
) {
    val TAGS = "RegistrationScreen"
    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    var photoUri: Uri? by remember { mutableStateOf(null) }

    val launcher
            = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        uri?.let {
            photoUri = uri
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                bitmap.value = ImageDecoder.decodeBitmap(source)
                onImageSelected(bitmap.value)
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(){
            Row(
                modifier = Modifier
                    .size(120.dp)
                    .fillMaxWidth()
                    .clickable {
                        launcher.launch(
                            PickVisualMediaRequest(
                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                            )
                        )

                    }
                    .align(Alignment.CenterHorizontally)
            ) {

                if (photoUri != null) {
                    val painter = rememberAsyncImagePainter(
                        ImageRequest
                            .Builder(LocalContext.current)
                            .data(data = photoUri)
                            .build()
                    )
                    Image(
                        painter = painter,
                        contentScale = ContentScale.Crop,
                        contentDescription = "",
                        modifier = Modifier
                            .clip(shape = CircleShape)
                    )
                } else {
                    Image(
                        painterResource(R.drawable.ic_add_a_photo),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(shape = CircleShape)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(all = MEDIUM_PADDING)
            ) {
                // name
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = { onNameChange(it) },
                    label = { Text(text = stringResource(id = R.string.name)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // firstFamilyName
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = firstFamilyName,
                    onValueChange = { onFirstFamilyNameChange(it) },
                    label = { Text(text = stringResource(id = R.string.first_family_name)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // secondFamilyName
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = secondFamilyName,
                    onValueChange = { onSecondFamilyNameChange(it) },
                    label = { Text(text = stringResource(id = R.string.second_family_name)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // age
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = age,
                    onValueChange = { onAgeChange(it) },
                    label = { Text(text = stringResource(id = R.string.age)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // email
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { onEmailChange(it) },
                    label = { Text(text = stringResource(id = R.string.email)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // dob
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = dob,
                    onValueChange = { onDobChange(it) },
                    label = { Text(text = stringResource(id = R.string.dob)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // street
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = street,
                    onValueChange = { onStreetChange(it) },
                    label = { Text(text = stringResource(id = R.string.street)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // number
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = number,
                    onValueChange = { onNumberChange(it) },
                    label = { Text(text = stringResource(id = R.string.number)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // neighborhood
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = neighborhood,
                    onValueChange = { onNeighborhoodChange(it) },
                    label = { Text(text = stringResource(id = R.string.neighborhood)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // municipality
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = municipality,
                    onValueChange = { onMunicipalityChange(it) },
                    label = { Text(text = stringResource(id = R.string.municipality)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // state
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state,
                    onValueChange = { onStateChange(it) },
                    label = { Text(text = stringResource(id = R.string.state)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                // zipCode
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = zipCode,
                    onValueChange = { onZipCodeChange(it) },
                    label = { Text(text = stringResource(id = R.string.zip_code)) },
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true
                )
                Divider(
                    modifier = Modifier.height(MEDIUM_PADDING),
                    color = MaterialTheme.colors.background
                )
                Button(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(),
                    onClick = {
                        onSave()
                        photoUri = null
                    }
                ) {
                    Text(
                        text = "Guardar")
                }
            }
        }
    }
}