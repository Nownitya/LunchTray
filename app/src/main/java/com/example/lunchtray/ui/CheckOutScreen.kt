package com.example.lunchtray.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.OrderUiState
import com.example.lunchtray.ui.theme.LunchTrayTheme

@Composable
fun CheckOutScreen(
    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(
            text = stringResource(id = R.string.order_summary),
            fontWeight = FontWeight.Bold
        )
        ItemSummary(item = orderUiState.entree, modifier = Modifier.fillMaxSize())
        ItemSummary(item = orderUiState.sideDish, modifier = Modifier.fillMaxSize())
        ItemSummary(item = orderUiState.accompaniment, modifier = Modifier.fillMaxSize())

        HorizontalDivider(
            thickness = dimensionResource(id = R.dimen.thickness_divider),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )

        OrderSubCost(
            resourceId = R.string.subtotal,
            price = orderUiState.itemTotalPrice.formatPrice(),
            modifier = Modifier.align(Alignment.End)

        )
        OrderSubCost(
            resourceId = R.string.tax,
            price = orderUiState.orderTax.formatPrice(),
            modifier = Modifier.align(Alignment.End)
        )
        Text(
            text = stringResource(id = R.string.total, orderUiState.itemTotalPrice.formatPrice()),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.End)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.cancel).uppercase())
            }
            Button(
                onClick = onNextButtonClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.submit).uppercase())
            }
        }
    }
}

@Composable
fun OrderSubCost(
    @StringRes resourceId: Int,
    price: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = resourceId, price),
        modifier = modifier
    )
}

@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item?.name ?: "")
        Text(text = item?.getFormattedPrice() ?: "")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "DarkPreview",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CheckOutScreenPreviewDark() {
    LunchTrayTheme {
        CheckOutScreen(
            orderUiState = OrderUiState(
                entree = DataSource.entreeMenuItems[0],
                sideDish = DataSource.sideDishMenuItems[0],
                accompaniment = DataSource.accompanimentItem[0],
                itemTotalPrice = 15.0,
                orderTax = 1.0,
                orderTotalPrice = 16.0
            ),
            onNextButtonClicked = {},
            onCancelButtonClicked = {},
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
fun CheckOutScreenPreviewLight() {
    LunchTrayTheme {
        CheckOutScreen(
            orderUiState = OrderUiState(
                entree = DataSource.entreeMenuItems[0],
                sideDish = DataSource.sideDishMenuItems[0],
                accompaniment = DataSource.accompanimentItem[0],
                itemTotalPrice = 15.0,
                orderTax = 1.0,
                orderTotalPrice = 16.0
            ),
            onNextButtonClicked = {},
            onCancelButtonClicked = {},
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview
@Composable
fun CheckOutScreenPreviewNeutral() {
    LunchTrayTheme {
        CheckOutScreen(
            orderUiState = OrderUiState(
                entree = DataSource.entreeMenuItems[0],
                sideDish = DataSource.sideDishMenuItems[0],
                accompaniment = DataSource.accompanimentItem[0],
                itemTotalPrice = 15.0,
                orderTax = 1.0,
                orderTotalPrice = 16.0
            ),
            onNextButtonClicked = {},
            onCancelButtonClicked = {},
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(rememberScrollState())
        )
    }
}