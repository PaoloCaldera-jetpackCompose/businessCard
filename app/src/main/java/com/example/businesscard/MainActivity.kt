package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeMainActivity()
                }
            }
        }
    }
}


/*
    LAYOUT
 */
@Composable
fun ComposeMainActivity(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(colorResource(id = R.color.teal_700))
            .padding(16.dp)
    ) {
        Person(
            name = stringResource(R.string.name),
            occupation = stringResource(R.string.occupation),
            modifier = modifier.weight(2f)
        )
        Contacts(
            cellphone = stringResource(R.string.cellphone),
            user = stringResource(R.string.user),
            email = stringResource(R.string.email),
            modifier = modifier.weight(1f)
        )
    }
}

// Build the person layout block
@Composable
fun Person(name: String, occupation: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = stringResource(R.string.content_description_android_logo),
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white)
        )
        Text(
            text = occupation,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_200)
        )
    }
}

// Build the contacts layout block
@Composable
fun Contacts(cellphone: String, user: String, email: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ContactEntry(
            icon = painterResource(id = R.drawable.ic_phone),
            iconDescription = stringResource(R.string.content_description_cellphone),
            text = cellphone
        )
        ContactEntry(
            icon = painterResource(id = R.drawable.ic_share),
            iconDescription = stringResource(R.string.content_description_username),
            text = user
        )
        ContactEntry(
            icon = painterResource(id = R.drawable.ic_email),
            iconDescription = stringResource(R.string.content_description_email),
            text = email
        )
    }
}

// In the contacts layout block, build the entry layout
@Composable
fun ContactEntry(
    icon: Painter,
    iconDescription: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(start = 32.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = iconDescription,
            modifier = modifier.padding(end = 8.dp),
            tint = colorResource(id = R.color.teal_200)
        )
        Text(text = text, color = colorResource(id = R.color.white))
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeMainActivityPreview() {
    BusinessCardTheme {
        ComposeMainActivity()
    }
}