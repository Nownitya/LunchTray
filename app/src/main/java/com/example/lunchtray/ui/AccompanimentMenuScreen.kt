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
import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.ui.theme.LunchTrayTheme

@Composable
fun AccompanimentMenuScreen(
    options: List<AccompanimentItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionItemChanged: (AccompanimentItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
//    onSelectionChanged = onSelectionItemChanged as (MenuItem) -> Unit,
        onSelectionChanged = { item ->
            onSelectionItemChanged(item as AccompanimentItem)
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
fun AccompanimentMenuPreviewDark() {
    LunchTrayTheme {
        AccompanimentMenuScreen(
            options = DataSource.accompanimentItem,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionItemChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(rememberScrollState())
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
fun AccompanimentMenuPreviewLight() {
    LunchTrayTheme {
        AccompanimentMenuScreen(
            options = DataSource.accompanimentItem,
            onCancelButtonClicked = {  },
            onNextButtonClicked = {  },
            onSelectionItemChanged = {  },
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview
@Composable
fun AccompanimentMenuPreviewNeutral() {
    LunchTrayTheme {
        AccompanimentMenuScreen(
            options = DataSource.accompanimentItem,
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