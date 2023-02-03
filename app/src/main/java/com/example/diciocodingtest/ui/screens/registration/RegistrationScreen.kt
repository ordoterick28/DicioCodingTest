package com.example.diciocodingtest.ui.screens.registration

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    val TAGS = "RegistrationScreen"


    val name: String by viewModel.name
    val firstFamilyName: String by viewModel.firstFamilyName
    val secondFamilyName: String by viewModel.secondFamilyName
    val age: String by viewModel.age
    val email: String by viewModel.email
    val dob: String by viewModel.dob
    //info
    val street: String by viewModel.street
    val number: String by viewModel.number
    val neighborhood: String by viewModel.neighborhood
    val municipality: String by viewModel.municipality
    val state: String by viewModel.state
    val zipCode: String by viewModel.zipCode
//    val base64: String by viewModel.base64

    val user by viewModel.user.collectAsState()
    Log.d(TAGS, "eom-> $user")

    Scaffold(
        topBar = { },
        content = {
            RegistrationContent(
                name = name,
                onNameChange = {
                    viewModel.updateName(it)
                },
                firstFamilyName = firstFamilyName,
                onFirstFamilyNameChange = {
                    viewModel.updateFirstFamilyName(it)
                },
                secondFamilyName = secondFamilyName,
                onSecondFamilyNameChange = {
                    viewModel.updateSecondFamilyName(it)
                },
                age = age,
                onAgeChange = {
                    viewModel.updateAge(it)
                },
                email = email,
                onEmailChange = {
                    viewModel.updateEmail(it)
                },
                dob = dob,
                onDobChange = {
                    viewModel.updateDob(it)
                },
                street = street,
                onStreetChange = {
                    viewModel.updateStreet(it)
                },
                number = number,
                onNumberChange = {
                    viewModel.updateNumber(it)
                },
                neighborhood = neighborhood,
                onNeighborhoodChange = {
                    viewModel.updateNeighborhood(it)
                },
                municipality = municipality,
                onMunicipalityChange = {
                    viewModel.updateMunicipality(it)
                },
                state = state,
                onStateChange = {
                    viewModel.updateState(it)
                },
                zipCode = zipCode,
                onZipCodeChange = {
                    viewModel.updateZipCode(it)
                },
                onImageSelected = {
                    it?.let { bitmap ->
                        viewModel.updateBase64String(bitmap)
                    }
                },
                onSave = {
                    viewModel.saveUser()
                }
            )
        }
    )
}