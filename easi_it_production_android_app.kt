// app/src/main/java/com/easiit/app/MainActivity.kt
package com.easiit.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity: ComponentActivity(){override fun onCreate(savedInstanceState: Bundle?){super.onCreate(savedInstanceState);setContent{EasiItApp()}}}

@Composable fun EasiItApp(){var tab by remember{mutableStateOf(0)}
Scaffold(topBar={TopAppBar(title={Text("Easi-it")})},bottomBar={NavigationBar{listOf("Home","Wallet","Scan","Profile").forEachIndexed{i,t->NavigationBarItem(selected=tab==i,onClick={tab=i},icon={},label={Text(t)})}}}){pad->Box(Modifier.padding(pad).padding(16.dp)){when(tab){0->Home();1->Wallet();2->Scan();3->Profile()}}}}

@Composable fun Stat(title:String,value:String){Card(Modifier.fillMaxWidth()){Column(Modifier.padding(16.dp)){Text(title);Text(value,style=MaterialTheme.typography.headlineMedium)}}}
@Composable fun Home(){LazyColumn(verticalArrangement=Arrangement.spacedBy(12.dp)){item{Stat("Meals Sponsored","124")};item{Stat("Nearby Vendors","6")};item{Button(onClick={}){Text("Sponsor Meal")}}}}
@Composable fun Wallet(){Column(verticalArrangement=Arrangement.spacedBy(12.dp)){Stat("Voucher Balance","3");Stat("Total Given","₦248,000")}}
@Composable fun Scan(){Column(verticalArrangement=Arrangement.spacedBy(12.dp)){Button(onClick={}){Text("Open Camera Scanner")};OutlinedTextField(value="",onValueChange={},label={Text("Voucher Code")});Button(onClick={}){Text("Redeem")}}}
@Composable fun Profile(){Column(verticalArrangement=Arrangement.spacedBy(12.dp)){Stat("Role","Vendor");Stat("EasiGrow Score","742");Button(onClick={}){Text("Logout")}}}

// build.gradle.kts summary
// implementation("androidx.compose.material3:material3")
// implementation("androidx.navigation:navigation-compose")
// implementation("androidx.camera:camera-camera2")
// implementation("com.journeyapps:zxing-android-embedded")
// implementation("io.github.jan-tennert.supabase:postgrest-kt")
// implementation("io.github.jan-tennert.supabase:gotrue-kt")
