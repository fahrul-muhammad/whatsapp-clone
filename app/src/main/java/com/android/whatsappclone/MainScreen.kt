package com.android.whatsappclone

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.Attribution
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.outlined.Api
import androidx.compose.material.icons.outlined.Attribution
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.whatsappclone.model.NavItem
import com.android.whatsappclone.view.CallScreen
import com.android.whatsappclone.view.ChatScreen
import com.android.whatsappclone.view.CommunityScreen
import com.android.whatsappclone.view.SettingScreen
import com.android.whatsappclone.view.UpdateScreen
import com.android.whatsappclone.viewmodel.ChatViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItemList = listOf<NavItem>(
        NavItem(
            label = "Pembaruan",
            selectedIcon = Icons.Filled.Attribution,
            unselectedIcon = Icons.Outlined.Attribution,
            hasNews = true,
        ),
        NavItem(
            label = "Panggilan",
            selectedIcon = Icons.Filled.Call,
            unselectedIcon = Icons.Outlined.Call,
            hasNews = false,
        ),
        NavItem(
            label = "Komunitas",
            selectedIcon = Icons.Filled.Groups,
            unselectedIcon = Icons.Outlined.Groups,
            hasNews = false,
        ),
        NavItem(
            label = "Chats",
            selectedIcon = Icons.Filled.Message,
            unselectedIcon = Icons.Outlined.Message,
            hasNews = false,
            badgeCount = 10
        ),
        NavItem(
            label = "Pengaturan",
            selectedIcon = Icons.Filled.Api,
            unselectedIcon = Icons.Outlined.Api,
            hasNews = false,
        )


    )

    var selectedItems by rememberSaveable {
        mutableStateOf(3)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black
            ) {
                navItemList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            disabledIconColor = colorResource(R.color.green),
                            disabledTextColor = colorResource(R.color.green),
                            selectedIconColor = colorResource(R.color.green_icon),
                            selectedTextColor = colorResource(R.color.white),
                            selectedIndicatorColor =  colorResource(R.color.green_chat),
                            unselectedIconColor = colorResource(R.color.white),
                            unselectedTextColor = colorResource(R.color.white)
                        ),
                        selected = selectedItems == index,
                        onClick = {
                            selectedItems = index
                        },
                        label = {
                            Text(text = item.label, fontWeight = if(selectedItems == index) FontWeight.Bold else FontWeight.Normal)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.badgeCount != null){
                                        Badge(){
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }else if(item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(imageVector = if(index == selectedItems ) {
                                    item.selectedIcon
                                }else item.unselectedIcon
                                    ,contentDescription = null)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = modifier.padding(innerPadding), selectedIndex = selectedItems)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex:Int = 3) {
    when(selectedIndex){
        0 -> UpdateScreen()
        1 -> CallScreen()
        2 -> CommunityScreen()
        3 -> ChatScreen()
        4 -> SettingScreen()
    }
}