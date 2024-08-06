package com.example.lunchtray.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.ui.theme.LunchTrayTheme

@Composable
fun EntreeMenuScreen(
    options: List<EntreeItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (EntreeItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
//    onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        onSelectionChanged = { item ->
            onSelectionChanged(item as EntreeItem)
        },
        modifier = modifier
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "DarkPreview",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun EntreeMenuPreviewDark() {
    LunchTrayTheme {
        EntreeMenuScreen(
            options = DataSource.entreeMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                )
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "LightPreview",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun EntreeMenuPreviewLight() {
    LunchTrayTheme {
        EntreeMenuScreen(
            options = DataSource.entreeMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                )
        )
    }
}

@Preview
@Composable
fun EntreeMenuPreviewNeutral() {
    LunchTrayTheme {
        EntreeMenuScreen(
            options = DataSource.entreeMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                )
        )
    }
}