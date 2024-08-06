package com.example.lunchtray

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.ui.theme.LunchTrayTheme

enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Entree(title = R.string.choose_entree),
    SideDish(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}


@Composable
private fun LuchTrayAppBar(
    currentScreenTitle: LunchTrayScreen,
//    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
//        title = { Text(stringResource(currentScreenTitle)) },
        title = { Text(stringResource(currentScreenTitle.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun LunchTrayApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?:LunchTrayScreen.Start.name
    )
    Scaffold(topBar = {
        LuchTrayAppBar(
            currentScreenTitle = currentScreen,
            canNavigateBack =navController.previousBackStackEntry !=null ,
            navigateUp = { navController.navigateUp() })
    }) { innerPadding-> dimensionResource(id = R.dimen.innerPadding)
        NavHost(
            navController = navController, startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {


        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "DarkPreview",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun OrderSummaryPreviewDark() {
    LunchTrayTheme {
        LunchTrayApp()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "LightPreview",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun OrderSummaryPreviewLight() {
    LunchTrayTheme {
        LunchTrayApp()
    }
}

@Preview
@Composable
fun OrderSummaryPreviewNeutral() {
    LunchTrayTheme {
        LunchTrayApp()
    }
}

