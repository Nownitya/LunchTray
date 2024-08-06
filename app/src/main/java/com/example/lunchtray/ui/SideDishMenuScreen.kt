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
import com.example.lunchtray.model.MenuItem.SideDishItem
import com.example.lunchtray.ui.theme.LunchTrayTheme

@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionItemChanged: (SideDishItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = { item ->
            onSelectionItemChanged(item as SideDishItem)
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
fun SideDishMenuPreviewDark() {
    LunchTrayTheme {
        SideDishMenuScreen(
            options = DataSource.sideDishMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionItemChanged = {  },
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
fun SideDishMenuPreviewLight() {
    LunchTrayTheme {
        SideDishMenuScreen(
            options = DataSource.sideDishMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionItemChanged = {  },
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
fun SideDishMenuPreviewNeutral() {
    LunchTrayTheme {
        SideDishMenuScreen(
            options = DataSource.sideDishMenuItems,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionItemChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                )
        )
    }
}