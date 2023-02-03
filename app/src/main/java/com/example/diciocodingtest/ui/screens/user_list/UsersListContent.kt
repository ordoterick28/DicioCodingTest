package com.example.diciocodingtest.ui.screens.user_list

import android.graphics.Bitmap
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.diciocodingtest.R
import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.ui.theme.SMALL_PADDING
import com.example.diciocodingtest.ui.theme.subtitleTaskItemBackgroundColor


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
fun  UsersListContent(
    usersList: LazyPagingItems<User>
) {
    DisplayUsers (
        usersList
    )
}




@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun DisplayUsers(
    usersList: LazyPagingItems<User>
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState
    ) {

        items(usersList){ user->
            user?.let{
                UserItem(
                    user = it,
                )
            }

        }
    }
}

@ExperimentalMaterialApi
@Composable
fun UserItem(
    user: User
) {

    val bitmap = mutableStateOf<Bitmap?>(null)

    LaunchedEffect(key1 = true) {
//        user.info?.image?.let {
        val symbol = ","
//            bitmap.value = Utils.base64ToBitmap(
////                base64String3.substringAfter(symbol)
//            )
//        }
    }

    user?.let {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RectangleShape,
        ) {
            Column(
                modifier = Modifier
                    .padding(all = SMALL_PADDING)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if(bitmap.value != null){
                        Image(
                            bitmap = bitmap.value!!.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop)
                    } else{
                        Image(
                            painterResource(R.drawable.profile),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape)
                        )
                    }
                    Spacer(Modifier.padding(12.dp))
                    Column() {
                        Text(
                            text = "${user.id.toString() ?: ""}  |  ${user.name ?: ""}",
                            style = MaterialTheme.typography.subtitle1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis)
                        Text(
                            "${user.email}", style = typography.body1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colors.subtitleTaskItemBackgroundColor)
                    }
                }

            }
        }
    }

}
