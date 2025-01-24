package com.android.whatsappclone.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int? = null
)
