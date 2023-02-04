package com.example.diciocodingtest.ui.screens.registration

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diciocodingtest.domain.model.InfoOut
import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.domain.model.UserOut
import com.example.diciocodingtest.domain.uses_cases.UseCases
import com.example.diciocodingtest.util.Utils
import com.google.gson.Gson

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@OptIn(ExperimentalSerializationApi::class)
@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    val TAGS = "RegistrationViewModel"
    private var _user: MutableStateFlow<User?> = MutableStateFlow(null)
    val user: StateFlow<User?> = _user

    var name = mutableStateOf("")
    var firstFamilyName = mutableStateOf("")
    var secondFamilyName = mutableStateOf("")
    var age = mutableStateOf("")
    var email = mutableStateOf("")
    var dob = mutableStateOf("")

    var street = mutableStateOf("")
    var number = mutableStateOf("")
    var neighborhood = mutableStateOf("")
    var municipality = mutableStateOf("")
    var state = mutableStateOf("")
    var zipCode = mutableStateOf("")
    var base64String = mutableStateOf("")
    val photoUri = mutableStateOf<Uri?>(null)

    fun saveUser(){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val infoOut = InfoOut(
                    street = street.value,
                    number = number.value,
                    neighborhood = neighborhood.value,
                    municipality = municipality.value,
                    state = state.value,
                    zipCode = zipCode.value,
                    image = base64String.value
                )
                val user = UserOut(
                    name = name.value,
                    firstFamilyName = firstFamilyName.value,
                    secondFamilyName = secondFamilyName.value,
                    age = age.value.toInt(),
                    email = email.value,
                    dob = dob.value,
                    info = Utils.formatJsonString(infoOut)
                )
                Log.d(TAGS, "eom-> $user")
                useCases.saveUserUCase.invoke(user)
                clearFields()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun clearFields(){
        name.value = ""
        firstFamilyName.value = ""
        secondFamilyName.value = ""
        age.value = ""
        email.value = ""
        dob.value = ""

        street.value = ""
        number.value = ""
        neighborhood.value = ""
        municipality.value = ""
        state.value = ""
        zipCode.value = ""
        base64String.value = ""
        photoUri.value = null
    }

    fun updateName(newName:String){
        name.value = newName
    }

    fun updateFirstFamilyName(newValue:String){
        firstFamilyName.value = newValue
    }

    fun updateSecondFamilyName(newValue:String){
        secondFamilyName.value = newValue
    }

    fun updateAge(newValue:String){
        age.value = newValue
    }

    fun updateEmail(newValue:String){
        email.value = newValue
    }

    fun updateDob(newValue:String){
        dob.value = newValue
    }

    fun updateStreet(newValue:String){
        street.value = newValue
    }

    fun updateNumber(newValue:String){
        number.value = newValue
    }

    fun updateNeighborhood(newValue:String){
        neighborhood.value = newValue
    }

    fun updateMunicipality(newValue:String){
        municipality.value = newValue
    }

    fun updateState(newValue:String){
        state.value = newValue
    }

    fun updateZipCode(newValue:String){
        zipCode.value = newValue
    }

    fun updateUri(newValue:Uri){
        photoUri.value = newValue
    }

    fun updateBase64String(bitmap: Bitmap) {
        base64String.value = Utils.bitmapToBase64(bitmap) ?: ""
    }

}